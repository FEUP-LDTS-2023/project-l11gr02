package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.dra.tombmask.view.GameView;
import com.dra.tombmask.view.HeroView;
import com.dra.tombmask.view.SpikeView;
import com.dra.tombmask.view.WallView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ArenaViewTest {
    private GUI gui;
    private GameView gameView;

    @BeforeEach
    void setup() {
        Arena arena = new Arena(10, 10);
        this.gui = Mockito.mock(GUI.class);
        this.gameView = new GameView(arena);
    }
    @Test
    public void drawWallTest() {
        gameView.drawGame(gui,new Wall(1,3),new WallView());
        gameView.drawGame(gui,new Wall(1,4),new WallView());
        gameView.drawGame(gui,new Wall(2,3),new WallView());
        gameView.drawGame(gui,new Wall(2,4),new WallView());

        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,3));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,4));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,3));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,4));
        Mockito.verify(gui, Mockito.times(4)).drawWall(Mockito.any(Position.class));
    }
    @Test
    public void drawListWallsTest() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1,3));
        walls.add(new Wall(1,4));
        walls.add(new Wall(2,3));
        walls.add(new Wall(2,4));

        gameView.drawGame(gui,walls,new WallView());

        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,3));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,4));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,3));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,4));
        Mockito.verify(gui, Mockito.times(4)).drawWall(Mockito.any(Position.class));
    }

    @Test
    public void drawHeroTest() {
        gameView.drawGame(gui,new Hero(new Position(1,3)),new HeroView());
        Mockito.verify(gui,Mockito.times(1)).drawHero(new Position(1,3));
    }
    @Test
    public void drawSpikeTest() {
        gameView.drawGame(gui,new Spike(1,3),new SpikeView());
        Mockito.verify(gui,Mockito.times(1)).drawSpike(new Position(1,3));
    }
    @Test
    public void drawSpikeListTest() {
        List<Spike> spikes = new ArrayList<>();
        spikes.add(new Spike(1,3));
        spikes.add(new Spike(1,4));
        spikes.add(new Spike(2,3));
        spikes.add(new Spike(3,4));

        gameView.drawGame(gui,spikes,new SpikeView());

        Mockito.verify(gui,Mockito.times(1)).drawSpike(new Position(1,3));
        Mockito.verify(gui,Mockito.times(1)).drawSpike(new Position(1,4));
        Mockito.verify(gui,Mockito.times(1)).drawSpike(new Position(2,3));
        Mockito.verify(gui,Mockito.times(1)).drawSpike(new Position(3,4));
        Mockito.verify(gui, Mockito.times(4)).drawSpike(Mockito.any(Position.class));
    }
}
