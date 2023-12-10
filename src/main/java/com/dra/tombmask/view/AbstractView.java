package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.utils.*;


import java.io.IOException;

public abstract class AbstractView<T> {
    private final T model;

    public AbstractView(T model){
        this.model = model;
    }

    public T getModel() { return this.model; }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawModel(gui);
        gui.refresh();
    }

    public abstract void drawModel(GUI gui) throws IOException;

}
