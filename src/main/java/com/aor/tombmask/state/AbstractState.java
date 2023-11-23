package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.AbstractController;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.AbstractView;

import java.io.IOException;


public abstract class AbstractState<T> {
    private final AbstractController<T> controller;
    private final T model;
    private final AbstractView<T> viewer;

    public AbstractState(T model){
        this.controller = getEspecificController();
        this.viewer = getEspecificViewer();
        this.model = model;
    }

    public abstract AbstractController<T> getEspecificController();
    public abstract AbstractView<T> getEspecificViewer();

    public T getModel() { return model; }

    public void nextState(Game game, GUI gui) throws IOException{
        ACTION action = gui.getAction(gui.getUserInput());
        controller.nextState(game, action);
        viewer.draw(gui);
    }

}
