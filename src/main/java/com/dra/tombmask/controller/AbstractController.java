package com.dra.tombmask.controller;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;

public abstract class AbstractController<T> {
    private final T model;

    public AbstractController(T model){
        this.model = model;
    }

    public T getModel() { return model; }

    public abstract void executeState(Game game, ACTION action, GUI gui) throws IOException;
}
