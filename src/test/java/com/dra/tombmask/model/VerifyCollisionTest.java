package com.dra.tombmask.model;

import com.dra.tombmask.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyCollisionTest {
    private Arena arena;

    @Test
    public void isBat() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/testlevel");
        Position position = new Position(3,4);

        boolean tmp = false;

        for(Bat bat : arena.getBats()){
            if(bat.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isSpike() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/testlevel");

        Position position = new Position(1,2);

        boolean tmp = false;

        for(Spike spike : arena.getSpikes()){
            if(spike.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isCoin() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/testlevel");

        Position position = new Position(1,2);

        boolean tmp = false;

        for(Collectable collectable : arena.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Coin) tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isStar() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level2");
        List<Collectable> stars = new ArrayList<>();
        stars.add(new Star(3,2));

        arena.setCollectables(stars);

        Position position = new Position(3,3);

        boolean tmp = false;

        for(Collectable collectable : arena.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Star) tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isPoint() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level2");
        List<Collectable> points = new ArrayList<>();
        points.add(new Point(4,4));

        arena.setCollectables(points);

        Position position = new Position(4,4);

        boolean tmp = false;

        for(Collectable collectable : arena.getCollectables()){
            if(collectable.getPosition().equals(position)){
                if(collectable instanceof Point) tmp = true;
            }
        }

        Assertions.assertTrue(tmp);
    }

    @Test
    public void isWall() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level1");

        Position position = new Position(4,4);

        boolean tmp = false;

        for(Wall wall : arena.getWalls()){
            if(wall.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertFalse(tmp);
    }

    @Test
    public void isEnd() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/testlevel");
        Position position = new Position(8,6);

        Assertions.assertTrue(arena.isEnd(position));
    }
}
