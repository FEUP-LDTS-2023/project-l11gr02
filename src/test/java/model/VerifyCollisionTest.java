package model;

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
    /*
    @BeforeEach
    public void setup() throws IOException {
        this.arena = new Arena(30,30,"docs/level1");
    }*/

    @Test
    public void isBat() throws IOException{
        this.arena = new Arena(30,30,"docs/level1");
        Position position = new Position(7,2);

        Assertions.assertEquals(true,arena.hasItemAtPosition(arena.getBats(),position));
    }

    @Test
    public void isSpike() throws IOException{
        this.arena = new Arena(30,30,"docs/level3");

        Position position = new Position(1,2);

        Assertions.assertEquals(false,arena.hasItemAtPosition(arena.getSpikes(),position));
    }

    @Test
    public void isCoin() throws IOException{
        this.arena = new Arena(30,30,"docs/level1");
        coins = new ArrayList<>();
        coins.add(new Coin(3,2));

        arena.setCoins(coins);

        Position position = new Position(3,2);

        Assertions.assertEquals(true,arena.hasItemAtPosition(arena.getCoins(),position));
    }

    @Test
    public void isStar() throws IOException{
        this.arena = new Arena(30,30,"docs/level2");
        stars = new ArrayList<>();
        stars.add(new Star(3,2));

        arena.setStars(stars);

        Position position = new Position(3,3);

        Assertions.assertEquals(false,arena.hasItemAtPosition(arena.getStars(),position));
    }

    @Test
    public void isPoint() throws IOException{
        this.arena = new Arena(30,30,"docs/level2");
        points = new ArrayList<>();
        points.add(new Point(4,4));

        arena.setPoints(points);

        Position position = new Position(4,4);

        Assertions.assertEquals(true,arena.hasItemAtPosition(arena.getPoints(),position));
    }

    @Test
    public void isWall() throws IOException{
        this.arena = new Arena(30,30,"docs/level1");

        Position position = new Position(4,4);

        Assertions.assertEquals(false,arena.hasItemAtPosition(arena.getWalls(),position));
    }

    @Test
    public void isEnd() throws IOException{
        this.arena = new Arena(30,30,"docs/level1");
        Position position = new Position(8,8);

        Assertions.assertEquals(true,arena.isEnd(position));
    }
}
