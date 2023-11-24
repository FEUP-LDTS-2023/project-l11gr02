package com.dra.tombmask.state;


import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.MenuController;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.MainMenuView;

import java.io.IOException;

public class MenuState implements AbstractState {
    private final Menu menu;
    private final MenuController menuController;
    private final MainMenuView mainMenuView;
    public MenuState(GUI gui) throws IOException {
        this.menu = new Menu();
        menuController = new MenuController(menu);
        mainMenuView = new MainMenuView(menu);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException {
        ACTION action = gui.getAction(gui.getUserInput());
        menuController.executeState(game, action, gui);
        mainMenuView.draw(gui);
    }
}