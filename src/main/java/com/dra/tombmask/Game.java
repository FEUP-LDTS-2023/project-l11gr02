package com.dra.tombmask;
import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.state.AbstractState;
import com.dra.tombmask.state.MenuState;

import java.awt.*;
import java.io.IOException;

public class Game {
    private final GUI gui;
    private AbstractState state;
    public int currentTomb;

    public Game() throws IOException, FontFormatException {
        this.gui = new GUI();
        this.state = new MenuState();
        this.currentTomb = 1;
    }

    public void setState(AbstractState state){
        this.state = state;
    }
    public void setCurrentTomb(int i) { this.currentTomb = i; }

    public int getCurrentTomb() {
        return currentTomb;
    }

    public AbstractState getState(){
        return state;
    }

    public void run() throws IOException, InterruptedException {
        while(state != null){
            int FPS = 14;
            int frameTime = 1000/FPS;
            long startTime = System.currentTimeMillis();
            state.nextState(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }
        gui.close();
    }
}
