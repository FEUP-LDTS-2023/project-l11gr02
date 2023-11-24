package com.dra.tombmask.controller;

import com.dra.tombmask.model.Arena;

public abstract class GameController extends AbstractController<Arena>{
    public GameController(Arena arena) {
        super(arena);
    }
}
