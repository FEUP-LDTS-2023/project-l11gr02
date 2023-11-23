package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.GameController;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class GameState implements AbstractState{

    @Override
    public void nextState(Game game, GUI gui) throws IOException {
        ACTION action = gui.getAction(gui.getUserInput());
    }
}
