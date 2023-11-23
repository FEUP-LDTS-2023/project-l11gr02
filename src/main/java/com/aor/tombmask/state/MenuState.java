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
    public MenuState(GUI gui) throws IOException {
        this.menu = new Menu();
        new MainMenuView(menu).draw(gui);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException {
        ACTION action = gui.getAction(gui.getUserInput());
        new MenuController(menu).executeState(game, action);
        new MainMenuView(menu).draw(gui);
    }
}