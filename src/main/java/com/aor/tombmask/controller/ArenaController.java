package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Bat;
import com.aor.tombmask.state.MenuState;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class ArenaController extends AbstractController<Arena>{
    private final HeroController heroController;
    private final BatController batController;
    public ArenaController(Arena arena) {
        super(arena);
        heroController = new HeroController(arena);
        batController = new BatController(arena);
    }

    @Override
    public void executeState(Game game, ACTION action, GUI gui) throws IOException, InterruptedException {
        switch (action){
            case EXIT:
                game.setState(new MenuState(gui));
                break;
            default:
                heroController.executeState(game, action, gui);
        }
    }
}
