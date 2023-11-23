package com.aor.tombmask;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.state.AbstractState;
import com.aor.tombmask.state.MenuState;

import java.io.IOException;

public class Game {
    private final GUI gui;
    private AbstractState state;

    public Game() throws IOException {
        this.gui = new GUI();
        this.state = new MenuState(gui);
    }

    public void setState(AbstractState state){
        this.state = state;
    }

    public void run() throws IOException {
        while(state != null){
            state.nextState(this, gui);
        }
        gui.close();
    }
}
