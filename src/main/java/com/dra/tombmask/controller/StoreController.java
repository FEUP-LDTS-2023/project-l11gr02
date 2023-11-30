package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.state.StoreState;
import com.dra.tombmask.utils.ACTION;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class StoreController extends AbstractController<Store>{
    public StoreController(Store model) {
        super(model);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        switch (action) {
            case UP:
                getModel().upMenu();
                break;
            case DOWN:
                getModel().downMenu();
                break;
            case ENTER:
                if(getModel().getCurrentMask().equals("EXIT")){
                    exit(game);
                    game.setState(new MenuState());
                }
                consumeOption(game);
                break;
            case EXIT:
                exit(game);
                game.setState(new MenuState());
        }
    }
    private void consumeOption(Game game){
        String currentMask = getModel().getCurrentMask();
        if(getModel().getOwnedMasks().contains(currentMask)){
            getModel().selectMask(currentMask); return;
        }
        getModel().buyMask(currentMask);
    }

    public void exit(Game game) throws IOException {
        FileWriter fileWriter = new FileWriter(Store.pathPricesMasks);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(String mask : getModel().getAvailableMasks()){
            printWriter.println(mask + "=" + getModel().getMaskPriceMap().get(mask));
        }
        printWriter.println("CURRENT_COINS="+getModel().getCurrentCoins());
        fileWriter.close();
        //game.setState(new MenuState());
    }
}
