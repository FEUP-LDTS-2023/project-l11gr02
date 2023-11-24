package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.EndLevel;

public class EndLevelView implements ElementView<EndLevel>{
    @Override
    public void draw(EndLevel endLevel, GUI gui) {
        gui.drawEndLevel(endLevel.getPosition());
    }
}
