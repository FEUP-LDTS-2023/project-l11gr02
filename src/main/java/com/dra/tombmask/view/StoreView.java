package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.AbstractState;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class StoreView extends AbstractView<Store> {

    private final List<String> availableMasks;

    public StoreView(Store model) {
        super(model);
        this.availableMasks = Arrays.asList("h","1","2");
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.drawText(10,1,"STORE");
        for(int i = 0 ; i < availableMasks.size(); i++) {
            gui.drawBox(10,1+((i+1)*3),availableMasks.get(i));
        }
        gui.drawSelectable(GUI.WIDTH - ("EXIT".length()+ 3),GUI.HEIGHT-1,"EXIT",true);
    }
}
