package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public abstract class GameController extends AbstractController<Arena>{
    public GameController(Arena arena) {
        super(arena);
    }
}
