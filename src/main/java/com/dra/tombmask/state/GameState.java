package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.ArenaController;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameView;

import java.io.IOException;

public class GameState implements AbstractState{
    public ArenaController arenaController;
    public GameView gameViewer;
    public GameState() throws IOException {
        Arena arena = new Arena(60,30,Game.currentPath);
        arenaController = new ArenaController(arena);
        gameViewer = new GameView(arena);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        ACTION action = gui.getAction(gui.getUserInput());
        arenaController.executeState(game, action);
        gameViewer.draw(gui);
    }

    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GameState gameState)) return false;

        return gameState.arenaController.getModel().getWidth() == arenaController.getModel().getWidth()
                && gameState.arenaController.getModel().getHeight() == arenaController.getModel().getHeight()
                && gameState.arenaController.getModel().getPath().equals(arenaController.getModel().getPath());
    }
}
