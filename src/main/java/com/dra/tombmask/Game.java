package com.dra.tombmask;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.state.AbstractState;
import com.dra.tombmask.state.MenuState;

import java.awt.*;
import java.io.IOException;

public class Game {
    private final GUI gui;
    private AbstractState state;

    public Game() throws IOException, FontFormatException {
        this.gui = new GUI();
        this.state = new MenuState(gui);
    }

    public void setState(AbstractState state){
        this.state = state;
    }

    public void run() throws IOException, InterruptedException {
        while(state != null){
            long startTime = System.currentTimeMillis();
            state.nextState(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = 100 - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}
