package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.StoreController;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.StoreView;

import java.io.IOException;

public class StoreState implements AbstractState {
    private StoreController storeController;
    private StoreView storeView;

    public StoreState(Store store) {
        storeController = new StoreController(store);
        storeView = new StoreView(store);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        ACTION action = gui.getAction(gui.getUserInput());
        storeController.executeState(game,action);
        storeView.draw(gui);
    }
}
