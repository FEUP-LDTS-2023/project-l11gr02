package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.TombController;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameView;

import java.io.IOException;

public class GameState implements AbstractState{
    public TombController tombController;
    public GameView gameViewer;
    public GameState(Tomb tomb) throws IOException {
        tombController = new TombController(tomb);
        gameViewer = new GameView(tomb);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        ACTION action = gui.getAction(gui.getUserInput());
        tombController.executeState(game, action);
        gameViewer.draw(gui);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        GameState gameState = (GameState) obj;

        return gameState.tombController.getModel().getWidth() == tombController.getModel().getWidth()
                && gameState.tombController.getModel().getHeight() == tombController.getModel().getHeight()
                && gameState.tombController.getModel().getPath().equals(tombController.getModel().getPath());
    }
}
