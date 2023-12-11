package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MiscView implements ElementView<Element> {





    @Override
    public void draw(Element element, GUI gui) {
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        if(element instanceof Coin){
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ElementsSymbol.coinCollectable.symbol);
        }
        else if(element instanceof Point){
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ElementsSymbol.pointCollectable.symbol);
        }
        else if(element instanceof Star){
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ElementsSymbol.starCollectable.symbol);
        }
        else if(element instanceof Trampoline) {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ElementsSymbol.getTrampolineCorner(((Trampoline) element).getCorner()));
        }
        else if(element instanceof PowerUp){
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ElementsSymbol.getPowerUp((PowerUp) element));
        }
    }
}
