package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ArenaTest {
    private Arena arena;

    @Test
    public void widthTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        Assertions.assertEquals(30,arena.getWidth());
    }

    @Test
    public void heightTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        Assertions.assertEquals(30,arena.getHeight());
    }

    @Test
    public void endLevelTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        arena.setEndLevel(new EndLevel(2,2));
        Assertions.assertEquals(new EndLevel(2,2),arena.getEndLevel());
        Assertions.assertTrue(arena.isEnd(new Position(2, 2)));
    }

    @Test
    public void heroTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        arena.setHero(new Hero(new Position(5,5)));
        Assertions.assertEquals(new Hero(new Position(5,5)),arena.getHero());
    }

    @Test
    public void batTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        List<Bat> bats = new ArrayList<>();
        bats.add(new Bat(new Position(1,1), true));
        bats.add(new Bat(new Position(4,6),false));
        arena.setBats(bats);

        Assertions.assertEquals(bats,arena.getBats());
    }

    @Test
    public void wallTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(0,0));
        walls.add(new Wall(0,1));
        arena.setWalls(walls);

        Assertions.assertEquals(walls,arena.getWalls());
    }

    @Test
    public void spikeTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        List<Spike> spikes = new ArrayList<>();
        spikes.add(new Spike(0,0));
        spikes.add(new Spike(0,1));
        arena.setSpikes(spikes);

        Assertions.assertEquals(spikes,arena.getSpikes());
    }

    @Test
    public void getElementAtPositionTest() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");
        Position position1 = new Position(1,1);
        Position position2 = new Position(2,3);
        Assertions.assertEquals(new Coin(1,1),arena.getElementAtPosition(position1));
        Assertions.assertNull(arena.getElementAtPosition(position2));
    }

    @Test
    public void isEmpty() throws IOException{
        arena = new Arena(30,30,"src/main/resources/levels/level1");

        Position position = new Position(2,3);
        Assertions.assertTrue(arena.isEmpty(position));
    }

    @Test
    public void globalElementsTest(){
        arena = new Arena(30,30);
        List<Element> globalElements = new ArrayList<>();
        globalElements.add(new Wall(0,0));
        globalElements.add(new Coin(1,4));
        globalElements.add(new Hero(new Position(1,1)));

        arena.setGlobalElements(globalElements);
        Assertions.assertEquals(globalElements,arena.getGlobalElements());
    }
}
