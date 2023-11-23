package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public abstract class AbstractController<T> {
    private final T model;

    public AbstractController(T model){
        this.model = model;
    }

    public T getModel() { return model; }

    public abstract void executeState(Game game, ACTION action) throws IOException;
}
