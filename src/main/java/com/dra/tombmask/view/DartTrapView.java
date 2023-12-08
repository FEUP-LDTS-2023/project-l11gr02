package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.DartTrap;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DartTrapView implements ElementView<DartTrap>{
    public void draw(DartTrap trap, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        TerminalPosition terminalPosition = new TerminalPosition(trap.getPosition().getX(), trap.getPosition().getY());
        textGraphics.putString(terminalPosition, ElementsSymbol.getTrapDirection(trap.getDirection()));
    }
}
