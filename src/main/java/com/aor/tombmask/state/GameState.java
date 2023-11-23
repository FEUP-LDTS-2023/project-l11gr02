package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.ArenaController;
import com.aor.tombmask.controller.GameController;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.GameView;

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
