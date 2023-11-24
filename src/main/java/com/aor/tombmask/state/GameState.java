package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.ArenaController;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.GameView;

import java.io.IOException;

public class GameState implements AbstractState{
    private final ArenaController arenaController;
    private final GameView gameViewer;
    public GameState(Arena arena) throws IOException {
        arenaController = new ArenaController(arena);
        gameViewer = new GameView(arena);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        ACTION action = gui.getAction(gui.getUserInput());
        arenaController.executeState(game, action);
        gameViewer.draw(gui);
    }
}
