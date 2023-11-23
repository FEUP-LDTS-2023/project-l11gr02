package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Hero;

public class HeroView implements ElementView<Hero>{
    public void draw(Hero hero, GUI gui){
        gui.drawHero(hero.getPosition());
    }
}
