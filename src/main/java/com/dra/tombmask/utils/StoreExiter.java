package com.dra.tombmask.utils;

import com.dra.tombmask.model.Store;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StoreExiter {

    private final Store store;
    public PrintWriter printWriter;

    public String path;

    public StoreExiter(Store model, String path){
        this.store = model;
        this.path = path;
    }
    public void exit() throws IOException {
        Writer fileWriter = Files.newBufferedWriter(Paths.get(path), UTF_8);
        this.printWriter = new PrintWriter(fileWriter);
        for(String mask : store.getAvailableMasks()){
            printWriter.println(mask + "=" + store.getMaskPriceMap().get(mask));
        }
        printWriter.println("CURRENT_COINS="+store.getCurrentCoins());
        fileWriter.close();
    }
}
