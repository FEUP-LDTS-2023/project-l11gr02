package com.dra.tombmask.controller;

import com.dra.tombmask.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeroTests {
    private Arena arena;
    private List<Coin> coins;
    private List<Star> stars;
    private List<Point> points;

    @BeforeEach
    public void setup() throws IOException {
        arena = new Arena(30,30,"docs/level1");

        coins = new ArrayList<>();
        coins.add(new Coin(1,1));
        coins.add(new Coin(2,2));
        coins.add(new Coin(0,3));

        stars = new ArrayList<>();
        stars.add(new Star(0,5));
        stars.add(new Star(1,3));
        stars.add(new Star(2,7));

        points = new ArrayList<>();
        points.add(new Point(0,7));
        points.add(new Point(1,4));
        points.add(new Point(2,3));

        arena.setCoins(coins);
        arena.setStars(stars);
        arena.setPoints(points);
    }

    @Test
    public void check_collision_coin(){
        String expected = "coin";
        int expected2 = 1;
        int expected3 = 2;

        HeroController heroController = new HeroController(arena);
        Position position = new Position(1,1);
        String r = heroController.checkCollision(position);

        Assertions.assertEquals(expected,r);
        Assertions.assertEquals(expected2,arena.getHero().getCollected_coins());
        Assertions.assertEquals(expected3,arena.getCoins().size());
    }

    @Test
    public void check_collision_star(){
        String expected = "star";
        int expected3 = 2;
        int expected4 = 1;

        HeroController heroController = new HeroController(arena);
        Position position1 = new Position(1,3);
        Position position2 = new Position(2,7);
        String r = heroController.checkCollision(position1);
        String s = heroController.checkCollision(position2);

        Assertions.assertEquals(expected,r);
        Assertions.assertEquals(expected,s);
        Assertions.assertEquals(expected3,arena.getHero().getCollected_stars());
        Assertions.assertEquals(expected4,arena.getStars().size());
    }

    @Test
    public void check_collision_point(){
        String expected = "point";
        int expected2 = 1;
        int expected3 = 2;

        HeroController heroController = new HeroController(arena);
        Position position = new Position(1,4);
        String r = heroController.checkCollision(position);

        Assertions.assertEquals(expected,r);
        Assertions.assertEquals(expected2,arena.getHero().getCollected_points());
        Assertions.assertEquals(expected3,arena.getPoints().size());
    }
}
