package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;
import java.util.Objects;

public class TombController extends AbstractController<Tomb>{
    private final MaskController maskController;
    private final BatController batController;
    private final DartController dartController;
    private final DartTrapController dartTrapController;
    public TombController(Tomb tomb) {
        super(tomb);
        maskController = new MaskController(tomb);
        batController = new BatController(tomb);
        dartController = new DartController(tomb);
        dartTrapController = new DartTrapController(tomb);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        batController.executeState(game, action);
        dartController.executeState(game, action);
        dartTrapController.executeState(game, action);
        if (Objects.requireNonNull(action) == ACTION.EXIT) {
            game.setState(new MenuState());
        } else {
            maskController.executeState(game, action);
        }
    }
}
