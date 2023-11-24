package com.aor.tombmask;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.state.AbstractState;
import com.aor.tombmask.state.MenuState;
import com.aor.tombmask.view.GameView;

import java.io.IOException;

public class Game {
    private final GUI gui;
    private AbstractState state;
    public GameView gameView;

    public Game() throws IOException {
        this.gui = new GUI();
        this.state = new MenuState(gui);
    }

    public void setState(AbstractState state){
        this.state = state;
    }
    public AbstractState getState(){
        return state;
    }

    public void setGameView(Arena arena) {
        gameView = new GameView(arena);
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
