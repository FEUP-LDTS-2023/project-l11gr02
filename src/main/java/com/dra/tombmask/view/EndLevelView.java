package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.EndLevel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

import com.googlecode.lanterna.graphics.TextGraphics;

public class EndLevelView implements ElementView<EndLevel>{
    @Override
    public void draw(EndLevel endLevel, GUI gui) {
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(endLevel.getColor()));
        TerminalPosition terminalPosition = new TerminalPosition(endLevel.getPosition().getX(),endLevel.getPosition().getY());
        textGraphics.putString(terminalPosition, endLevel.getSymbol());
    }
}
