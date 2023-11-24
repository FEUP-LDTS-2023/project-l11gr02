package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.ArenaController;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.GameView;

import java.io.IOException;

public class GameState implements AbstractState{
    private final Arena arena;
    private final ArenaController arenaController;
    public GameState(Arena arena, GUI gui) throws IOException {
        this.arena = arena;
        arenaController = new ArenaController(arena);
    }
    @Override
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        game.setGameView(arena);
        ACTION action = gui.getAction(gui.getUserInput());
        arenaController.executeState(game, action, gui);
        game.gameView.draw(gui);
    }
}
