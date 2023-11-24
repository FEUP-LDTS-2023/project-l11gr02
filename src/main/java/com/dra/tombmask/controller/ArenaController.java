package com.dra.tombmask.controller;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;

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
