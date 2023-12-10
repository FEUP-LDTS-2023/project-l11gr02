package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Spike;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SpikeView implements ElementView<Spike>{
    @Override
    public void draw(Spike spike, GUI gui) {
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        TerminalPosition terminalPosition = new TerminalPosition(spike.getPosition().getX(),spike.getPosition().getY());
        textGraphics.putString(terminalPosition, ElementsSymbol.spikeElement.symbol);
    }
}
