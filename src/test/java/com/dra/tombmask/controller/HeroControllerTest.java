package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeroControllerTest {
    Arena arena;
    HeroController heroController;
    Hero hero;
    @BeforeEach
    public void setup(){
        arena = new Arena(30,30);
        heroController = new HeroController(arena);
    }

    @Test
    public void moveHeroUpTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.UP);
        hero.setShieldedTime(10);

        Assertions.assertTrue(arena.isEmpty(new Position(4, 3)));
        Assertions.assertEquals(DIRECTION.UP,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(new Position(4, 3), hero.getPosition());
        Assertions.assertEquals(9.92,hero.getShieldedTime());
    }

    @Test
    public void moveHeroUpBlockedTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.UP);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4,3));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(4,3));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(4, 3)));
        Assertions.assertEquals(DIRECTION.UP,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(DIRECTION.IDLE, hero.getDirection());
        Assertions.assertEquals(new Wall(new Position(4,3)),heroController.checkCollision(new Position(4,3)));
    }

    @Test
    public void moveHeroDownTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.DOWN);

        Assertions.assertTrue(arena.isEmpty(new Position(4, 5)));
        Assertions.assertEquals(DIRECTION.DOWN,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(new Position(4, 5), hero.getPosition());
    }

    @Test
    public void moveHeroDownBlockedTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.DOWN);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4,5));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(4,5));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(4, 5)));
        Assertions.assertEquals(DIRECTION.DOWN,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(DIRECTION.IDLE, hero.getDirection());
        Assertions.assertEquals(new Wall(new Position(4,5)),heroController.checkCollision(new Position(4,5)));
    }

    @Test
    public void moveHeroLeftTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.LEFT);

        Assertions.assertTrue(arena.isEmpty(new Position(3, 4)));
        Assertions.assertEquals(DIRECTION.LEFT,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(new Position(3, 4), hero.getPosition());
    }

    @Test
    public void moveHeroLeftBlockedTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.LEFT);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(3,4));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(3,4));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(3, 4)));
        Assertions.assertEquals(DIRECTION.LEFT,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(DIRECTION.IDLE, hero.getDirection());
        Assertions.assertEquals(new Wall(new Position(3,4)),heroController.checkCollision(new Position(3,4)));
    }

    @Test
    public void moveHeroRightTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.RIGHT);

        Assertions.assertTrue(arena.isEmpty(new Position(5, 4)));
        Assertions.assertEquals(DIRECTION.RIGHT,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(new Position(5, 4), hero.getPosition());
    }

    @Test
    public void moveHeroRightBlockedTest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.RIGHT);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(5,4));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(5,4));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(5, 4)));
        Assertions.assertEquals(DIRECTION.RIGHT,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(DIRECTION.IDLE, hero.getDirection());
        Assertions.assertEquals(new Wall(new Position(5,4)),heroController.checkCollision(new Position(5,4)));
    }

    @Test
    public void moveHeroIDLETest(){
        hero =  arena.getHero();
        hero.setPosition(new Position(4,4));
        hero.setDirection(DIRECTION.IDLE);
        hero.setMagnetTime(10);

        Assertions.assertEquals(DIRECTION.IDLE,hero.getDirection());
        heroController.moveHero();
        Assertions.assertEquals(new Position(4, 4), hero.getPosition());
        Assertions.assertEquals(9.92,hero.getMagnetTime());
    }

    @Test
    public void executeStateUpTest() throws IOException, InterruptedException {
        hero = arena.getHero();
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getCurrentArena()).thenReturn(1);
        hero.setPosition(new Position(2,2));
        hero.setDirection(DIRECTION.IDLE);
        hero.setMagnetTime(5);

        Coin c1 = new Coin(1,2);
        Coin c2 = new Coin(2,3);
        Coin c3 = new Coin(4,5);
        List<Collectable> coins = new ArrayList<>();
        coins.add(c1);
        coins.add(c2);
        coins.add(c3);
        arena.setCollectables(coins);

        EndLevel e = new EndLevel(2,1);
        arena.setEndLevel(e);

        List<Element> elements =new ArrayList<>();
        elements.add(c1);
        elements.add(e);
        elements.add(c2);
        elements.add(c3);
        arena.setGlobalElements(elements);

        heroController.executeState(game, ACTION.UP);

        Assertions.assertEquals(1,arena.getCollectables().size());
        Assertions.assertEquals(2,arena.getGlobalElements().size());
        Assertions.assertEquals(DIRECTION.UP,hero.getDirection());
        Assertions.assertTrue(heroController.moveHero() instanceof EndLevel);
        Mockito.when(game.getCurrentArena()).thenReturn(2);
        Mockito.verify(game,Mockito.times(2)).setCurrentArena(game.currentArena+1);
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }

    @Test
    public void executeStateDownTest() throws IOException, InterruptedException {
        hero = arena.getHero();
        Game game = Mockito.mock(Game.class);
        hero.setPosition(new Position(2,2));
        hero.setDirection(DIRECTION.IDLE);
        hero.setShieldedTime(10);

        Bat bat = new Bat(new Position(2,3), true);
        List<Bat> bats = new ArrayList<>();
        bats.add(bat);
        arena.setBats(bats);

        List<Element> elements =new ArrayList<>();
        elements.add(bat);
        arena.setGlobalElements(elements);

        heroController.executeState(game, ACTION.DOWN);

        Assertions.assertEquals(DIRECTION.DOWN,hero.getDirection());
        Assertions.assertTrue(heroController.moveHero() instanceof Bat);
        Assertions.assertEquals(0.0,hero.getShieldedTime());
    }

    @Test
    public void executeStateLeftTest() throws IOException, InterruptedException {
        hero = arena.getHero();
        Game game = Mockito.mock(Game.class);
        hero.setPosition(new Position(2,2));
        hero.setDirection(DIRECTION.IDLE);
        hero.setShieldedTime(0);

        Spike spike = new Spike(new Position(1,2));
        List<Spike> spikes = new ArrayList<>();
        spikes.add(spike);
        arena.setSpikes(spikes);

        List<Element> elements =new ArrayList<>();
        elements.add(spike);
        arena.setGlobalElements(elements);

        heroController.executeState(game, ACTION.LEFT);

        Assertions.assertEquals(DIRECTION.LEFT,hero.getDirection());
        Assertions.assertTrue(heroController.moveHero() instanceof Spike);
        Assertions.assertFalse(hero.isShielded());
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }

    @Test
    public void executeStateRightTest() throws IOException, InterruptedException {
        hero = arena.getHero();
        Game game = Mockito.mock(Game.class);
        hero.setPosition(new Position(2,2));
        hero.setDirection(DIRECTION.IDLE);
        hero.setShieldedTime(10);

        Spike spike = new Spike(new Position(3,2));
        List<Spike> spikes = new ArrayList<>();
        spikes.add(spike);
        arena.setSpikes(spikes);

        List<Element> elements =new ArrayList<>();
        elements.add(spike);
        arena.setGlobalElements(elements);

        heroController.executeState(game, ACTION.RIGHT);

        Assertions.assertEquals(DIRECTION.RIGHT,hero.getDirection());
        Assertions.assertTrue(heroController.moveHero() instanceof Spike);
        Assertions.assertEquals(0.0,hero.getShieldedTime());
    }

    @Test
    public void collectAdjacentCoinsTest(){
        hero = arena.getHero();
        hero.setPosition(new Position(4,4));

        Coin c1 = new Coin(2,2);
        Coin c2 = new Coin(3,4);
        Coin c3 = new Coin(4,5);
        List<Collectable> coins = new ArrayList<>();
        coins.add(c1);
        coins.add(c2);
        coins.add(c3);
        arena.setCollectables(coins);

        List<Element> globalElements = new ArrayList<>();
        globalElements.add(c1);
        globalElements.add(c2);
        globalElements.add(c3);
        arena.setGlobalElements(globalElements);

        heroController.collectAdjacentCoins();
        Assertions.assertEquals(1,arena.getCollectables().size());
        Assertions.assertEquals(1,arena.getGlobalElements().size());
    }
}
