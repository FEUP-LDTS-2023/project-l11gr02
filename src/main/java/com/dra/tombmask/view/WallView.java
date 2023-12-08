package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Wall;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class WallView implements ElementView<Wall>{
    public void draw(Wall wall, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#993399"));
        textGraphics.putString(new TerminalPosition(wall.getPosition().getX(),wall.getPosition().getY()), ElementsSymbol.wallElement.symbol);
    }
}
