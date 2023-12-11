package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Element;

import java.io.IOException;

public abstract class StateExecuter {
    public abstract AbstractState createStateHandler() throws IOException;
    public void nextState(Game game, GUI gui) throws IOException, InterruptedException {
        AbstractState state = createStateHandler();
        state.nextState(game,gui);
    }
}
