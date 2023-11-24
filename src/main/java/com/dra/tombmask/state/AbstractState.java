package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;

import java.io.IOException;


public interface AbstractState {
    void nextState(Game game, GUI gui) throws IOException, InterruptedException;
}
