package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.dra.tombmask.utils.MENU_OPTION;
import com.dra.tombmask.view.GameView;
import com.dra.tombmask.view.HeroView;
import com.dra.tombmask.view.SpikeView;
import com.dra.tombmask.view.WallView;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
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
    public void drawMainMenuTest() throws IOException {
        MainMenuView m = new MainMenuView(new Menu());

        m.drawModel(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(5,5,"SIMPLE TOMB OF THE MASK");

        //melhorar
    }

    /*
    @Test
    public void drawModelTest(){
        gameView.drawModel(gui);

        //melhorar
    }

    @Test
    public void drawWallTest(){
        Wall wall1 = new Wall(1,3);
        Wall wall2 = new Wall(1,4);
        Wall wall3 = new Wall(2,3);
        Wall wall4 = new Wall(2,4);

        WallView wallView = new WallView();

        wallView.draw(wall1,gui);
        wallView.draw(wall2,gui);
        wallView.draw(wall3,gui);
        wallView.draw(wall4,gui);

        //Mockito.verify(gui,Mockito.times(1)).drawWall(wall1,gui);
        //Mockito.verify(gui,Mockito.times(1)).drawWall(wall2,gui);
        //Mockito.verify(gui,Mockito.times(1)).drawWall(wall3,gui);
        //Mockito.verify(gui,Mockito.times(1)).drawWall(wall4,gui);
        //Mockito.verify(gui, Mockito.times(4)).drawWall(Mockito.any(Wall.class),Mockito.any(GUI.class));
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
        Mockito.verify(gui,Mockito.times(1)).drawHero(new Position(1,3),false);
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

    @Test
    public void drawBatTest() {
        gameView.drawGame(gui,new Bat(new Position(1,3),true),new BatView());
        gameView.drawGame(gui,new Bat(new Position(2,4),false),new BatView());

        Mockito.verify(gui,Mockito.times(1)).drawBat(new Position(1,3));
        Mockito.verify(gui,Mockito.times(1)).drawBat(new Position(2,4));
        Mockito.verify(gui, Mockito.times(2)).drawBat(Mockito.any(Position.class));
    }

    @Test
    public void drawListBatsTest() {
        List<Bat> bats = new ArrayList<>();
        bats.add(new Bat(new Position(1,3),true));
        bats.add(new Bat(new Position(2,4),false));

        gameView.drawGame(gui,bats,new BatView());

        Mockito.verify(gui,Mockito.times(1)).drawBat(new Position(1,3));
        Mockito.verify(gui,Mockito.times(1)).drawBat(new Position(2,4));
        Mockito.verify(gui, Mockito.times(2)).drawBat(Mockito.any(Position.class));
    }

    @Test
    public void drawEndLevelTest() {
        gameView.drawGame(gui,new EndLevel(1,3),new EndLevelView());
        Mockito.verify(gui,Mockito.times(1)).drawEndLevel(new Position(1,3));
    }

    @Test
    void refreshAndClear() throws IOException {
        gameView.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }*/
}
