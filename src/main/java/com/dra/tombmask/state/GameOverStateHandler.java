package com.dra.tombmask.state;

import java.io.IOException;

public class GameOverStateHandler extends StateExecuter{
    @Override
    public AbstractState createStateHandler() throws IOException {
        return new GameOverState();
    }
}
