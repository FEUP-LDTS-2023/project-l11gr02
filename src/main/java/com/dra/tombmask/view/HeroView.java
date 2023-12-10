package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Hero;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class HeroView implements ElementView<Hero>{
    static public String heroSymbol = ElementsSymbol.defaultHero.symbol;

    public HeroView() throws IOException {
        Store store = new Store();
        heroSymbol = store.maskSymbolMap.get(store.getSelectedMask());
    }

    public void draw(Hero hero, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        TerminalPosition terminalPosition = new TerminalPosition(hero.getPosition().getX(),hero.getPosition().getY());
        textGraphics.putString(terminalPosition, !hero.isShielded() ? heroSymbol : ElementsSymbol.getShielded(heroSymbol));
    }
}
