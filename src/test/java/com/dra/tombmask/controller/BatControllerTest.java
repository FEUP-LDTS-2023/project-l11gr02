package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BatControllerTest {
    BatController batController;
    Bat bat;
    Tomb tomb;

    @BeforeEach
    public void setup() throws IOException {
        tomb = new Tomb(30,30);
        batController = new BatController(tomb);
    }
    @Test
    public void moveBatLeftTest(){
        bat = new Bat(5,5,false);

        Assertions.assertTrue(tomb.isEmpty(new Position(4, 5)));
        batController.moveBat(bat);
        Assertions.assertEquals(new Position(4, 5), bat.getPosition());
    }

    @Test
    public void moveBatRightTest(){
        bat = new Bat(5,5,true);
        DIRECTION expected = DIRECTION.RIGHT;

        Assertions.assertTrue(tomb.isEmpty(new Position(6, 5)));
        batController.moveBat(bat);
        Assertions.assertEquals(new Position(6, 5), bat.getPosition());
        Assertions.assertEquals(expected, bat.getDirection());
    }

    @Test
    public void moveBatBlockedRightTest(){
        bat = new Bat(5,5,true);

        Wall wall = new Wall(6,5);
        List<Wall> walls = new ArrayList<>();
        walls.add(wall);
        tomb.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(wall);
        tomb.setGlobalElements(elements);

        Assertions.assertFalse(tomb.isEmpty(new Position(6, 5)));
        batController.moveBat(bat);
        Assertions.assertEquals(new Position(5, 5), bat.getPosition());
        Assertions.assertEquals(DIRECTION.LEFT, bat.getDirection());
    }

    @Test
    public void moveBatBlockedLeftTest(){
        bat = new Bat(5,5,false);

        Wall wall = new Wall(4,5);
        List<Wall> walls = new ArrayList<>();
        walls.add(wall);
        tomb.setWalls(walls);

        List<Element> elements = new ArrayList<>();
        elements.add(wall);
        tomb.setGlobalElements(elements);

        Assertions.assertFalse(tomb.isEmpty(new Position(4, 5)));
        batController.moveBat(bat);
        Assertions.assertEquals(new Position(5, 5), bat.getPosition());
        Assertions.assertEquals(DIRECTION.RIGHT, bat.getDirection());
    }

    @Test
    public void moveBatTimeoutTest(){
        bat = new Bat(5,5,true);

        bat.setTimeout(10.0);

        batController.moveBat(bat);

        Assertions.assertEquals(9.84,bat.getTimeout());
    }

    @Test
    public void executeStateTest() throws IOException, FontFormatException, InterruptedException {
        Game game = Mockito.mock(Game.class);
        Tomb tomb = new Tomb(30,30);

        BatController b = new BatController(tomb);

        Bat bat1 = new Bat(1, 1, true);
        Bat bat2 = new Bat(2, 2, true);

        List<Bat> bats = new ArrayList<>();
        bats.add(bat1);
        bats.add(bat2);
        tomb.setBats(bats);

        b.executeState(game, ACTION.LEFT);

        Assertions.assertEquals(new Position(2,1), tomb.getBats().get(0).getPosition());
        Assertions.assertEquals(new Position(3,2), tomb.getBats().get(1).getPosition());
    }
}
