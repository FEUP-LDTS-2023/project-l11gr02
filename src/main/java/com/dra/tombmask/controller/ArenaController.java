package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;

public class ArenaController extends AbstractController<Arena>{
    private final MaskController maskController;
    private final BatController batController;
    private final DartController dartController;
    private final DartTrapController dartTrapController;
    public ArenaController(Arena arena) {
        super(arena);
        maskController = new MaskController(arena);
        batController = new BatController(arena);
        dartController = new DartController(arena);
        dartTrapController = new DartTrapController(arena);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        batController.executeState(game, action);
        dartController.executeState(game, action);
        dartTrapController.executeState(game, action);
        switch (action){
            case EXIT:
                game.setState(new MenuState());
                break;
            default:
                maskController.executeState(game, action);
        }
    }
}
