package com.dra.tombmask.model;

import com.dra.tombmask.utils.ElementsSymbol;
import com.dra.tombmask.view.HeroView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Store {

    private final List<String> availableMasks;
    private final Map<String,String> maskPriceMap;
    public final Map<String,String> maskSymbolMap;
    private String selectedMask;
    private final List<String> ownedMasks;
    private int currentIndex;

    private int currentCoins;
    static public String pathPricesMasks = "src/main/resources/masks/pricesMasks";
    static public String pathSymbolsMasks ="src/main/resources/masks/symbolMasks";

    public Store() throws IOException {
        this.availableMasks = new ArrayList<>();
        this.maskPriceMap = new HashMap<>();
        this.maskSymbolMap = new HashMap<>();
        this.ownedMasks = new ArrayList<>();
        this.selectedMask = "";
        this.currentIndex = 0;
        this.currentCoins = Hero.getCollected_coins();
        loadMasks(pathPricesMasks);
        loadSymbols();
        HeroView.heroSymbol = maskSymbolMap.get(selectedMask);
    }
    public Store(String path) throws IOException {
        this.availableMasks = new ArrayList<>();
        this.maskPriceMap = new HashMap<>();
        this.maskSymbolMap = new HashMap<>();
        this.ownedMasks = new ArrayList<>();
        this.selectedMask = "";
        this.currentIndex = 0;
        this.currentCoins = Hero.getCollected_coins();
        loadMasks(path);
        loadSymbols();
        HeroView.heroSymbol = maskSymbolMap.get(selectedMask);
    }
    private void loadMasks(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(Paths.get(path))));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            List<String> splitLine = List.of(line.split("="));
            if(splitLine.get(0).equals("CURRENT_COINS")) {
                this.currentCoins = Integer.parseInt(splitLine.get(1));
                continue;
            }
            if(Objects.equals(splitLine.get(1), "SEL")) this.selectedMask = splitLine.get(0);
            if(Objects.equals(splitLine.get(1), "SEL") || Objects.equals(splitLine.get(1), "OWNED"))
                ownedMasks.add(splitLine.get(0));
            maskPriceMap.put(splitLine.get(0),splitLine.get(1));
            availableMasks.add(splitLine.get(0));
        }
        bufferedReader.close();
    }
    private void loadSymbols() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(Paths.get(pathSymbolsMasks))));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            List<String> splitLine = List.of(line.split("="));
            maskSymbolMap.put(splitLine.get(0),splitLine.get(1));
        }
    }
    public void upMenu() {
        currentIndex--;
        if(currentIndex < 0) currentIndex = availableMasks.size() - 1;
    }
    public void downMenu() {
        currentIndex++;
        if(currentIndex > availableMasks.size() - 1) currentIndex = 0;
    }
    public String getCurrentMask() {return availableMasks.get(currentIndex);}
    public boolean isSelected(String mask) {return mask.equals(getCurrentMask());}
    public List<String> getAvailableMasks() {return this.availableMasks;}
    public List<String> getOwnedMasks() {return this.ownedMasks;}
    public String getSelectedMask() {return this.selectedMask;}
    public Map<String,String> getMaskPriceMap() {return this.maskPriceMap;}
    public int getCurrentCoins() {return this.currentCoins;}
    public int getCurrentIndex() {return this.currentIndex;}

    public void setCurrentCoins(int coins) {this.currentCoins = coins;}

    public void selectMask(String mask) {
        String selectedMask = getSelectedMask();
        getMaskPriceMap().put(selectedMask,"OWNED");
        getMaskPriceMap().put(mask,"SEL");
        this.selectedMask = mask;
        HeroView.heroSymbol = maskSymbolMap.get(mask);
    }
    public void buyMask(String mask){
        if(maskPriceMap.get(mask).equals("SEL") || maskPriceMap.get(mask).equals("OWNED"))
            return;
        if(Integer.parseInt(maskPriceMap.get(mask)) <= currentCoins) {
            currentCoins -= Integer.parseInt(maskPriceMap.get(mask));
            maskPriceMap.put(mask,"OWNED");
            ownedMasks.add(mask);
        }
    }
}