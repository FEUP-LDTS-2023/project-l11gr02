package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;

public class StoreController extends AbstractController<Store>{
    public StoreController(Store model) {
        super(model);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        if(action == ACTION.ENTER) game.setState(null);
    }
}
