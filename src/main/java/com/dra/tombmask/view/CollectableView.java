package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class CollectableView implements ElementView<Element> {

    @Override
    public void draw(Element element, GUI gui) {
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        if(element instanceof Coin){
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), "o");
        }
        else if(element instanceof Point){
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), ".");
        }
        else if(element instanceof Star){
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            textGraphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), "*");
        }
    }
}
