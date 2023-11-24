package com.aor.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.AbstractController;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.AbstractView;

import java.io.IOException;


public interface AbstractState {
    void nextState(Game game, GUI gui) throws IOException, InterruptedException;
}
