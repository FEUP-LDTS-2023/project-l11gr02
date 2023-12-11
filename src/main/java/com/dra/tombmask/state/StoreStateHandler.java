package com.dra.tombmask.state;

import com.dra.tombmask.model.Element;
import com.dra.tombmask.model.Store;

import java.io.IOException;

public class StoreStateHandler extends StateExecuter{
    @Override
    public AbstractState createStateHandler() throws IOException {
        return new StoreState();
    }
}
