package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Dart;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DartView implements ElementView<Dart>{
    public void draw(Dart dart, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#90EE90"));
        TerminalPosition terminalPosition = new TerminalPosition(dart.getPosition().getX(), dart.getPosition().getY());
        textGraphics.putString(terminalPosition, ".");
    }
}
