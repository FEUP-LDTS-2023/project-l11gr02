package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Collectable;
import com.dra.tombmask.model.EndLevel;
import com.dra.tombmask.model.Hero;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameView extends AbstractView<Arena>{
    public GameView(Arena arena){
        super(arena);
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        drawGame(gui, getModel().getWalls(), new WallView()); // draw walls
        drawGame(gui, getModel().getHero() ,new HeroView()); // draw hero
        drawGame(gui, getModel().getBats(), new BatView()); // draw bat
        drawGame(gui, getModel().getSpikes(), new SpikeView());
        drawGame(gui, getModel().getEndLevel(), new EndLevelView());
        drawGame(gui, getModel().getGlobalElements(), new CollectableView());
    }

    public  <T> void drawGame(GUI gui, T element,ElementView<T> viewer){
        viewer.draw(element,gui);
    }
    public  <T> void drawGame(GUI gui, List<T> elements, ElementView<T> viewer){
        for(T element: elements){
            viewer.draw(element, gui);
        }
    }
}
