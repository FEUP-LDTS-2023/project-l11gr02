package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.ArenaController;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameView;

import java.io.IOException;

public class GameState implements AbstractState{
    private final Arena arena;
    private final ArenaController arenaController;
    private final GameView gameViewer;
    public GameState(Arena arena, GUI gui) throws IOException {
        this.arena = arena;
        arenaController = new ArenaController(arena);
        gameViewer = new GameView(arena);
        gameViewer.draw(gui);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException {
        ACTION action = gui.getAction(gui.getUserInput());
        arenaController.executeState(game, action, gui);
        gameViewer.draw(gui);
    }
}
