package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.powerups.PowerUpStrategy;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.CORNER;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaskControllerTest {
    Arena arena;
    MaskController maskController;

    Game game;
    Mask mask;
    @BeforeEach
    public void setup() throws IOException {
        arena = new Arena(30,30);
        maskController = new MaskController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    public void moveMaskUpTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.UP);
        mask.setShieldedTime(10);

        Assertions.assertTrue(arena.isEmpty(new Position(4, 3)));
        Assertions.assertEquals(DIRECTION.UP, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(new Position(4, 3), mask.getPosition());
        Assertions.assertEquals(9.92, mask.getShieldedTime());
    }

    @Test
    public void moveMaskUpBlockedTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.UP);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4,3));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(4,3));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(4, 3)));
        Assertions.assertEquals(DIRECTION.UP, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(DIRECTION.IDLE, mask.getDirection());
        Assertions.assertEquals(new Wall(new Position(4,3)), maskController.checkCollision(new Position(4,3)));
    }

    @Test
    public void moveMaskDownTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.DOWN);

        Assertions.assertTrue(arena.isEmpty(new Position(4, 5)));
        Assertions.assertEquals(DIRECTION.DOWN, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(new Position(4, 5), mask.getPosition());
    }

    @Test
    public void moveMaskDownBlockedTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.DOWN);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4,5));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(4,5));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(4, 5)));
        Assertions.assertEquals(DIRECTION.DOWN, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(DIRECTION.IDLE, mask.getDirection());
        Assertions.assertEquals(new Wall(new Position(4,5)), maskController.checkCollision(new Position(4,5)));
    }

    @Test
    public void moveMaskLeftTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.LEFT);

        Assertions.assertTrue(arena.isEmpty(new Position(3, 4)));
        Assertions.assertEquals(DIRECTION.LEFT, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(new Position(3, 4), mask.getPosition());
    }

    @Test
    public void moveMaskLeftBlockedTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.LEFT);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(3,4));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(3,4));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(3, 4)));
        Assertions.assertEquals(DIRECTION.LEFT, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(DIRECTION.IDLE, mask.getDirection());
        Assertions.assertEquals(new Wall(new Position(3,4)), maskController.checkCollision(new Position(3,4)));
    }

    @Test
    public void moveMaskRightTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.RIGHT);

        Assertions.assertTrue(arena.isEmpty(new Position(5, 4)));
        Assertions.assertEquals(DIRECTION.RIGHT, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(new Position(5, 4), mask.getPosition());
    }

    @Test
    public void moveMaskRightBlockedTest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.RIGHT);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(5,4));
        arena.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(new Wall(5,4));
        arena.setGlobalElements(elements);

        Assertions.assertFalse(arena.isEmpty(new Position(5, 4)));
        Assertions.assertEquals(DIRECTION.RIGHT, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(DIRECTION.IDLE, mask.getDirection());
        Assertions.assertEquals(new Wall(new Position(5,4)), maskController.checkCollision(new Position(5,4)));
    }

    @Test
    public void moveMaskIDLETest(){
        mask =  arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.IDLE);
        mask.setMagnetTime(10);

        Assertions.assertEquals(DIRECTION.IDLE, mask.getDirection());
        maskController.moveMask();
        Assertions.assertEquals(new Position(4, 4), mask.getPosition());
        Assertions.assertEquals(9.92, mask.getMagnetTime());
    }


    @Test
    public void executeStateUpTest() throws IOException, InterruptedException {
        mask = arena.getMask();
        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getCurrentArena()).thenReturn(1);
        mask.setPosition(new Position(2,2));
        mask.setDirection(DIRECTION.IDLE);
        mask.setMagnetTime(5);

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

        maskController.executeState(game, ACTION.UP);

        Assertions.assertEquals(1,arena.getCollectables().size());
        Assertions.assertEquals(2,arena.getGlobalElements().size());
        Assertions.assertEquals(DIRECTION.UP, mask.getDirection());
        Assertions.assertTrue(maskController.moveMask() instanceof EndLevel);
        Mockito.when(game.getCurrentArena()).thenReturn(2);
        Mockito.verify(game,Mockito.times(2)).setCurrentArena(game.currentArena+1);
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }

    @Test
    public void executeStateDownTest() throws IOException, InterruptedException {
        mask = arena.getMask();
        Game game = Mockito.mock(Game.class);
        mask.setPosition(new Position(2,2));
        mask.setDirection(DIRECTION.IDLE);
        mask.setShieldedTime(10);

        Bat bat = new Bat(new Position(2,3), true);
        List<Bat> bats = new ArrayList<>();
        bats.add(bat);
        arena.setBats(bats);

        List<Element> elements =new ArrayList<>();
        elements.add(bat);
        arena.setGlobalElements(elements);

        maskController.executeState(game, ACTION.DOWN);

        Assertions.assertEquals(DIRECTION.DOWN, mask.getDirection());
        Assertions.assertTrue(maskController.moveMask() instanceof Bat);
        Assertions.assertEquals(0.0, mask.getShieldedTime());
    }

    @Test
    public void executeStateLeftTest() throws IOException, InterruptedException {
        mask = arena.getMask();
        Game game = Mockito.mock(Game.class);
        mask.setPosition(new Position(2,2));
        mask.setDirection(DIRECTION.IDLE);
        mask.setShieldedTime(0);

        Spike spike = new Spike(new Position(1,2));
        List<Spike> spikes = new ArrayList<>();
        spikes.add(spike);
        arena.setSpikes(spikes);

        List<Element> elements =new ArrayList<>();
        elements.add(spike);
        arena.setGlobalElements(elements);

        maskController.executeState(game, ACTION.LEFT);

        Assertions.assertEquals(DIRECTION.LEFT, mask.getDirection());
        Assertions.assertTrue(maskController.moveMask() instanceof Spike);
        Assertions.assertFalse(mask.isShielded());
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }

    @Test
    public void executeStateRightTest() throws IOException, InterruptedException {
        mask = arena.getMask();
        Game game = Mockito.mock(Game.class);
        mask.setPosition(new Position(2,2));
        mask.setDirection(DIRECTION.IDLE);
        mask.setShieldedTime(10);

        Spike spike = new Spike(new Position(3,2));
        List<Spike> spikes = new ArrayList<>();
        spikes.add(spike);
        arena.setSpikes(spikes);

        List<Element> elements =new ArrayList<>();
        elements.add(spike);
        arena.setGlobalElements(elements);

        maskController.executeState(game, ACTION.RIGHT);

        Assertions.assertEquals(DIRECTION.RIGHT, mask.getDirection());
        Assertions.assertTrue(maskController.moveMask() instanceof Spike);
        Assertions.assertEquals(0.0, mask.getShieldedTime());
    }

    @Test
    public void collectAdjacentCoinsTest(){
        mask = arena.getMask();
        mask.setPosition(new Position(4,4));

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

        maskController.collectAdjacentCoins();
        Assertions.assertEquals(1,arena.getCollectables().size());
        Assertions.assertEquals(1,arena.getGlobalElements().size());
    }

    @Test
    public void checkCollisionCollectableTest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        Coin coin = Mockito.mock(Coin.class);
        Mockito.when(mockArena.getElementAtPosition(Mockito.any(Position.class))).thenReturn(coin);

        maskController1.checkCollision(new Position(0,0));

        Mockito.verify(coin,Mockito.times(1)).collect(Mockito.any(Arena.class));
    }
    @Test
    public void checkCollisionPowerUpTest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        PowerUp powerUp = Mockito.mock(PowerUp.class);
        PowerUpStrategy powerUpStrategy = Mockito.mock(PowerUpStrategy.class);
        Mockito.when(mockArena.getElementAtPosition(Mockito.any(Position.class))).thenReturn(powerUp);
        Mockito.when(powerUp.getStrategy()).thenReturn(powerUpStrategy);

        maskController1.checkCollision(new Position(0,0));

        Mockito.verify(powerUp,Mockito.times(1)).getStrategy();
    }
    @Test
    public void handleTrampolineTOPLEFTCollisiontest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        Trampoline trampoline = new Trampoline(new Position(0,0), CORNER.TOPLEFT);
        Mask mask1 = Mockito.mock(Mask.class);
        Mockito.when(mockArena.getMask()).thenReturn(mask1);

        maskController1.handleTrampolineCollision(trampoline);

        Mockito.verify(mask1,Mockito.times(1)).setDirection(Mockito.any(DIRECTION.class));
    }
    @Test
    public void handleTrampolineTOPRIGHTCollisiontest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        Trampoline trampoline = new Trampoline(new Position(0,0), CORNER.TOPRIGHT);
        Mask mask1 = Mockito.mock(Mask.class);
        Mockito.when(mockArena.getMask()).thenReturn(mask1);

        maskController1.handleTrampolineCollision(trampoline);

        Mockito.verify(mask1,Mockito.times(1)).setDirection(Mockito.any(DIRECTION.class));
    }
    @Test
    public void handleTrampolineBOTLEFTCollisiontest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        Trampoline trampoline = new Trampoline(new Position(0,0), CORNER.BOTLEFT);
        Mask mask1 = Mockito.mock(Mask.class);
        Mockito.when(mockArena.getMask()).thenReturn(mask1);

        maskController1.handleTrampolineCollision(trampoline);

        Mockito.verify(mask1,Mockito.times(1)).setDirection(Mockito.any(DIRECTION.class));
    }
    @Test
    public void handleTrampolineBOTRIGHTCollisiontest() {
        Arena mockArena = Mockito.mock(Arena.class);
        MaskController maskController1 = new MaskController(mockArena);
        Trampoline trampoline = new Trampoline(new Position(0,0), CORNER.BOTRIGHT);
        Mask mask1 = Mockito.mock(Mask.class);
        Mockito.when(mockArena.getMask()).thenReturn(mask1);

        maskController1.handleTrampolineCollision(trampoline);

        Mockito.verify(mask1,Mockito.times(1)).setDirection(Mockito.any(DIRECTION.class));
    }
}
