package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class GameController extends AbstractController<Game>{
    public GameController(Game game) {
        super(game);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException {

    }
}
