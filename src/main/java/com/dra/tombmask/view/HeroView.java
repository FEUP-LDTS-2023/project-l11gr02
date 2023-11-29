package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Hero;

public class HeroView implements ElementView<Hero>{
    public void draw(Hero hero, GUI gui){
        gui.drawHero(hero.getPosition(), hero.isShielded());
    }
}
