package com.dra.tombmask.controller;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.controller.*;

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
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        batController.executeState(game, action);
        switch (action){
            case EXIT:
                game.setState(new MenuState());
                break;
            default:
                heroController.executeState(game, action);
        }
    }
}
