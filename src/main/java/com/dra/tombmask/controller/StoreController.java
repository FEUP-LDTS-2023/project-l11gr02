package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.*;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.StoreExiter;
import java.io.IOException;

public class StoreController extends AbstractController<Store>{
    public StoreExiter storeExiter;
    public StoreController(Store model) throws IOException {
        super(model);
        storeExiter = new StoreExiter(model, Store.pathPricesMasks);
    }

    public StoreController(Store model,StoreExiter storeExiter) {
        super(model);
        this.storeExiter = storeExiter;
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        StateExecuter stateExecuter;
        switch (action) {
            case UP:
                getModel().upMenu();
                break;
            case DOWN:
                getModel().downMenu();
                break;
            case ENTER:
                if(getModel().getCurrentMask().equals("EXIT")){
                    storeExiter.exit();
                    stateExecuter = new MenuStateHandler();
                    game.setState(stateExecuter.createStateHandler());
                }
                consumeOption(getModel().getCurrentMask());
                break;
            case EXIT:
                storeExiter.exit();
                stateExecuter = new MenuStateHandler();
                game.setState(stateExecuter.createStateHandler());
        }
    }
    void consumeOption(String mask){
        if(getModel().getOwnedMasks().contains(mask)){
            getModel().selectMask(mask); return;
        }
        getModel().buyMask(mask);
    }
}
