package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.state.MenuState;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class ArenaController extends AbstractController<Arena>{
    public ArenaController(Arena arena) {
        super(arena);
    }

    @Override
    public void executeState(Game game, ACTION action, GUI gui) throws IOException {
        switch (action){
            case EXIT:
                game.setState(new MenuState(gui));
                break;
            default:
                // other controllers
        }
    }
}
