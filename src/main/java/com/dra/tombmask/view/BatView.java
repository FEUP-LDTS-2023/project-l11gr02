package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Bat;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BatView implements ElementView<Bat>{
    public void draw(Bat bat, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        TerminalPosition terminalPosition = new TerminalPosition(bat.getPosition().getX(),bat.getPosition().getY());
        textGraphics.putString(terminalPosition, ElementsSymbol.batEnemy.symbol);
    }

}
