package com.dra.tombmask.state;


import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.MenuController;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.MainMenuView;

import java.io.IOException;

public class MenuState implements AbstractState {
    public MenuController menuController;
    public MainMenuView mainMenuView;
    public MenuState() throws IOException {
        Menu menu = new Menu();
        menuController = new MenuController(menu);
        mainMenuView = new MainMenuView(menu);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException {
        ACTION action = gui.getAction(gui.getUserInput());
        menuController.executeState(game, action);
        mainMenuView.draw(gui);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj != null && getClass() == obj.getClass();
    }
}