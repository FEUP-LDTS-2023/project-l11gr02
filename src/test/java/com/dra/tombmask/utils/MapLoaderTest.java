package com.dra.tombmask.utils;

import com.dra.tombmask.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapLoaderTest {
    static private final String pathLevelTest = "./src/main/resources/levels/testlevel";
    static private final String pathLevel1 = "./src/main/resources/levels/level1";
    static private final String pathLevel3 = "./src/main/resources/levels/level3";
    static private final String pathLevel6 = "./src/main/resources/levels/level6";
    static private final String pathLevel8 = "./src/main/resources/levels/level8";
    @Test
    public void openFileTest() throws IOException {
        String upperWall = "WWWWWWWWWW";
        MapLoader mapLoader = new MapLoader(pathLevelTest);
        assert mapLoader.getGlobalPositions().contains(upperWall);
    }
    @Test
    public void positionHandlerTest() throws IOException {
        Position expectedMaskPosition = new Position(3,1);

        MapLoader mapLoader = new MapLoader(pathLevelTest);

        assertEquals(expectedMaskPosition.getY(),mapLoader.getMask().getPosition().getY());
        assertEquals(expectedMaskPosition.getX(),mapLoader.getMask().getPosition().getX());
    }

    @Test
    public void positionBatHandlerTest() throws IOException {
        List<Bat> expectedBatPositions = new ArrayList<>();
        expectedBatPositions.add(new Bat(4,3, true));
        expectedBatPositions.add(new Bat(3,4, true));

        MapLoader mapLoader = new MapLoader(pathLevelTest);

        for(int i = 0; i < expectedBatPositions.size(); i++) {
            Bat p1 = expectedBatPositions.get(i);
            Bat p2 = mapLoader.getBats().get(i);
            assertEquals(p1.getPosition().getX(),p2.getPosition().getX());
            assertEquals(p1.getPosition().getY(),p2.getPosition().getY());
        }
    }
    @Test
    public void positionWallHandlerTest() throws IOException {

        MapLoader mapLoader = new MapLoader(pathLevelTest);
        List<Position> expectedWallPositions = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            expectedWallPositions.add(new Position(c,0));
            expectedWallPositions.add(new Position(c,7));
        }
        for (int r = 1; r < 7; r++){
            expectedWallPositions.add(new Position(0,r));
            expectedWallPositions.add(new Position(9,r));
        }
        expectedWallPositions.add(new Position(7,6));
        for(Wall wall : mapLoader.getWalls()) {
            assert expectedWallPositions.contains(wall.getPosition());
        }
    }
    @Test
    public void positionSpikeHandlerTest() throws IOException {
        MapLoader mapLoader = new MapLoader(pathLevel3);
        List<Position> expectedSpikePositions = new ArrayList<>();

        for(Spike spike : mapLoader.getSpikes()) {
            System.out.println(spike.getPosition().getX());
            System.out.println(spike.getPosition().getY());
            System.out.println();
        }

        expectedSpikePositions.add(new Position(23,5));
        expectedSpikePositions.add(new Position(23,9));

        for(Spike spike : mapLoader.getSpikes()) {
            assert expectedSpikePositions.contains(spike.getPosition());
        }
    }

    @Test
    public void magnetTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel8);

        Position position = new Position(6,13);

        boolean tmp = false;
        for(PowerUp powerUp: mapLoader.getPowerUps()){
            if(powerUp.getPosition().equals(position)) tmp = true;
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void getSpikesTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel3);

        List<Spike> expected = new ArrayList<>();
        expected.add(new Spike(23,5));
        expected.add(new Spike(23,9));

        Assertions.assertEquals(expected,mapLoader.getSpikes());
    }

    @Test
    public void getWallsTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel1);

        Assertions.assertEquals(31,mapLoader.getWalls().size());
    }

    @Test
    public void getAvailableStarsTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel3);

        Assertions.assertEquals(2,mapLoader.getAvailableStars());
    }

    @Test
    public void getDartTrapsTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel1);

        Assertions.assertEquals(2,mapLoader.getDartTraps().size());
    }

    @Test
    public void shieldTest() throws IOException{
        MapLoader mapLoader = new MapLoader(pathLevel6);

        Position position = new Position(17,2);
        boolean tmp = false;
        for(PowerUp powerUp: mapLoader.getPowerUps()){
            if(powerUp.getPosition().equals(position)) tmp = true;
        }

        Assertions.assertTrue(tmp);
    }
}
