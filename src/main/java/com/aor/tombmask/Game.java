package com.aor.tombmask;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.state.AbstractState;
import com.aor.tombmask.state.MenuState;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.utils.MENU_OPTION;
import com.aor.tombmask.view.MainMenuView;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    private final GUI gui;
    private AbstractState state;
    public Game() throws IOException {
        this.gui = new GUI();
        this.state = new MenuState(new Menu());
    }

    public void setState(AbstractState state) {
        this.state = state;
    }


    public void run() throws IOException {
        while(state != null) {
            state.nextState(this, gui);
        }
        gui.close();
    }
}
