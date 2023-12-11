package com.dra.tombmask.model;

import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.ShieldStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TombTest {
    private Tomb tomb;

    @Test
    public void widthTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        Assertions.assertEquals(30, tomb.getWidth());
    }

    @Test
    public void heightTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        Assertions.assertEquals(30, tomb.getHeight());
    }

    @Test
    public void endLevelTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        EndLevel e = new EndLevel(2,2);
        tomb.setEndLevel(e);
        Assertions.assertEquals(e, tomb.getEndLevel());
        Assertions.assertTrue(new Position(2,2).equals(e.getPosition()));
    }

    @Test
    public void maskTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        tomb.setMask(new Mask(new Position(5,5)));
        Assertions.assertEquals(new Mask(new Position(5,5)), tomb.getMask());
    }

    @Test
    public void batTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        List<Bat> bats = new ArrayList<>();
        bats.add(new Bat(new Position(1,1), true));
        bats.add(new Bat(new Position(4,6),false));
        tomb.setBats(bats);

        Assertions.assertEquals(bats, tomb.getBats());
    }

    @Test
    public void wallTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(0,0));
        walls.add(new Wall(0,1));
        tomb.setWalls(walls);

        Assertions.assertEquals(walls, tomb.getWalls());
    }

    @Test
    public void spikeTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        List<Spike> spikes = new ArrayList<>();
        spikes.add(new Spike(0,0));
        spikes.add(new Spike(0,1));
        tomb.setSpikes(spikes);

        Assertions.assertEquals(spikes, tomb.getSpikes());
    }

    @Test
    public void getElementAtPositionTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");
        Position position1 = new Position(1,1);
        Position position2 = new Position(2,3);
        Assertions.assertEquals(new Point(1,1), tomb.getElementAtPosition(position1));
        Assertions.assertNull(tomb.getElementAtPosition(position2));
    }

    @Test
    public void isEmpty() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");

        Position position = new Position(2,3);
        Assertions.assertTrue(tomb.isEmpty(position));
    }

    @Test
    public void globalElementsTest() throws IOException {
        tomb = new Tomb(30,30);
        List<Element> globalElements = new ArrayList<>();
        globalElements.add(new Wall(0,0));
        globalElements.add(new Coin(1,4));
        globalElements.add(new Mask(new Position(1,1)));

        tomb.setGlobalElements(globalElements);
        Assertions.assertEquals(globalElements, tomb.getGlobalElements());
    }

    @Test
    public void pathTest() throws IOException{
        tomb = new Tomb(30,30,"src/main/resources/levels/level1");
        Assertions.assertEquals("src/main/resources/levels/level1", tomb.getPath());
    }

    @Test
    public void powerupsTest() throws IOException {
        tomb = new Tomb(30,30);

        PowerUp p1 = new PowerUp(new Position(2,3),new FreezeStrategy());
        PowerUp p2 = new PowerUp(new Position(1,1),new ShieldStrategy());
        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(p1);
        powerUps.add(p2);
        tomb.setPowerUps(powerUps);

        List<Element> elements =  new ArrayList<>();
        elements.add(p1);
        elements.add(p2);
        tomb.setGlobalElements(elements);

        Assertions.assertEquals(powerUps, tomb.getPowerUps());
    }
}
