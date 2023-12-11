package com.dra.tombmask.state;

import java.io.IOException;

public class MenuStateHandler extends StateExecuter{

    @Override
    public AbstractState createStateHandler() throws IOException {
        return new MenuState();
    }
}
