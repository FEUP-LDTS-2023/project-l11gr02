package com.aor.tombmask.state;


import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.AbstractController;
import com.aor.tombmask.controller.MenuController;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.state.AbstractState;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.AbstractView;
import com.aor.tombmask.view.MainMenuView;

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