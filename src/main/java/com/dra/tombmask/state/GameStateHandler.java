package com.dra.tombmask.state;

import java.io.IOException;

public class GameStateHandler extends StateExecuter{

    @Override
    public AbstractState createStateHandler() throws IOException {
        return new GameState();
    }
}
