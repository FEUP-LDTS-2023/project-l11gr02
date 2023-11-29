package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Hero;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroView implements ElementView<Hero>{
    public void draw(Hero hero, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(!hero.isShielded() ? "#FFFF00" : "#FF0000"));
        TerminalPosition terminalPosition = new TerminalPosition(hero.getPosition().getX(),hero.getPosition().getY());
        textGraphics.putString(terminalPosition, "h");
    }
}
