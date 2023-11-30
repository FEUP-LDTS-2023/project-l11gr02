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
    private List<Bat> bats;
    private List<Wall> walls;
    private List<Spike> spikes;
    private EndLevel end;
    private List<Coin> coins;
    private List<Star> stars;
    private List<Point> points;

    @Test
    public void isBat() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level1");
        Position position = new Position(7,2);

        boolean tmp = false;

        for(Bat bat : arena.getBats()){
            if(bat.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertEquals(true,tmp);
    }

    @Test
    public void isSpike() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level3");

        Position position = new Position(1,2);

        boolean tmp = false;

        for(Spike spike : arena.getSpikes()){
            if(spike.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertEquals(false,tmp);
    }

    @Test
    public void isCoin() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level1");
        coins = new ArrayList<>();
        coins.add(new Coin(3,2));

        arena.setCoins(coins);

        Position position = new Position(3,2);

        boolean tmp = false;

        for(Coin coin : arena.getCoins()){
            if(coin.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertEquals(true,tmp);
    }

    @Test
    public void isStar() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level2");
        stars = new ArrayList<>();
        stars.add(new Star(3,2));

        arena.setStars(stars);

        Position position = new Position(3,3);

        boolean tmp = false;

        for(Star star : arena.getStars()){
            if(star.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertEquals(false,tmp);
    }

    @Test
    public void isPoint() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level2");
        points = new ArrayList<>();
        points.add(new Point(4,4));

        arena.setPoints(points);

        Position position = new Position(4,4);

        boolean tmp = false;

        for(Point point : arena.getPoints()){
            if(point.getPosition().equals(position)){
                tmp = true;
            }
        }

        Assertions.assertEquals(true,tmp);
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

        Assertions.assertEquals(false,tmp);
    }

    @Test
    public void isEnd() throws IOException{
        this.arena = new Arena(30,30,"src/main/resources/levels/level1");
        Position position = new Position(8,8);

        Assertions.assertEquals(true,arena.isEnd(position));
    }
}
