package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyCollisionTest {
    private Tomb tomb;

    @Test
    public void isBat() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");
        Position position = new Position(3,4);

        boolean tmp = false;

        for(Bat bat : tomb.getBats()){
            if(bat.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isSpike() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");

        Position position = new Position(1,2);

        boolean tmp = false;

        for(Spike spike : tomb.getSpikes()){
            if(spike.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isCoin() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");

        Position position = new Position(1,2);

        boolean tmp = false;

        for(Collectable collectable : tomb.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Coin) tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isStar() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/level2");
        List<Collectable> stars = new ArrayList<>();
        stars.add(new Star(3,2));

        tomb.setCollectables(stars);

        Position position = new Position(3,3);

        boolean tmp = false;

        for(Collectable collectable : tomb.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Star) tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isPoint() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/level2");
        List<Collectable> points = new ArrayList<>();
        points.add(new Point(4,4));

        tomb.setCollectables(points);

        Position position = new Position(4,4);

        boolean tmp = false;

        for(Collectable collectable : tomb.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Point) tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isWall() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/level1");

        Position position = new Position(4,4);

        boolean tmp = false;

        for(Wall wall : tomb.getWalls()){
            if(wall.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isEnd() throws IOException{
        this.tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");
        Position position = new Position(8,6);

        Assertions.assertTrue(tomb.isEnd(position));
    }
}
