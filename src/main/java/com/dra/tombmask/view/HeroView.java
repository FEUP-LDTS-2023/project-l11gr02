package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Hero;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroView implements ElementView<Hero>{
    public void draw(Hero hero, GUI gui) {
        gui.drawElement(hero, gui);
    }
}
