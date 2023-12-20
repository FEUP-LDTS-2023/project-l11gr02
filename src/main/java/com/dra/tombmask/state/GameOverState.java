package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.GameOverController;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameOverView;

import java.io.IOException;

public class GameOverState implements AbstractState{
    public GameOverController gameOverController;
    public GameOverView gameOverView;
    public GameOverState() {
       GameOver gameOver = new GameOver();
       gameOverController = new GameOverController(gameOver);
       gameOverView = new GameOverView(gameOver);
    }

    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        ACTION action = gui.getAction(gui.getUserInput());
        gameOverController.executeState(game,action);
        gameOverView.draw(gui);
    }

    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GameOverState)) return false;

        return true;
    }
}
