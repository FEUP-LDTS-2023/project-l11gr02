package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Element;
import com.aor.tombmask.model.Hero;
import com.aor.tombmask.model.Wall;

import java.util.ArrayList;
import java.util.List;

public class GameView extends AbstractView<Arena>{
    public GameView(Arena arena){
        super(arena);
    }

    @Override
    public void drawModel(GUI gui) {
        drawGame(gui, getModel().getWalls(), new WallView()); // draw walls
        List<Hero> hero = new ArrayList<Hero>();
        hero.add(getModel().getHero());
        drawGame(gui, hero ,new HeroView()); // draw hero
        drawGame(gui, getModel().getBats(), new BatView()); // draw bat
    }

    private <T> void drawGame(GUI gui, List<T> elements, ElementView<T> viewer){
        for(T element: elements){
            viewer.draw(element, gui);
        }
    }
}
