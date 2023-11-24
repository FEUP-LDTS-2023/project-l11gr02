package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class GameView extends AbstractView<Arena>{
    public GameView(Arena arena){
        super(arena);
    }

    @Override
    public void drawModel(GUI gui) {
        drawGame(gui, getModel().getWalls(), new WallView()); // draw walls
        List<Hero> hero = new ArrayList<>();
        hero.add(getModel().getHero());
        drawGame(gui, hero ,new HeroView()); // draw hero
        drawGame(gui, getModel().getBats(), new BatView()); // draw bat
        drawGame(gui,getModel().getSpikes(), new SpikeView());

    }

    private <T> void drawGame(GUI gui, List<T> elements, ElementView<T> viewer){
        for(T element: elements){
            viewer.draw(element, gui);
        }
    }
}
