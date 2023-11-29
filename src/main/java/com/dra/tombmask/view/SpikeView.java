package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Spike;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SpikeView implements ElementView<Spike>{
    @Override
    public void draw(Spike spike, GUI gui) {
        gui.drawElement(spike,gui);
    }
}
