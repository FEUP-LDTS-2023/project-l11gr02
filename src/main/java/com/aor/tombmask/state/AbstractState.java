package com.aor.tombmask.state;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.controller.AbstractController;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.view.AbstractView;

import java.io.IOException;


public interface AbstractState {
    void nextState(Game game, GUI gui) throws IOException;
}
