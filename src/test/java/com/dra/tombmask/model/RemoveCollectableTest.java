package com.dra.tombmask.model;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Coin;
import com.dra.tombmask.model.Point;
import com.dra.tombmask.model.Star;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveCollectableTest {
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
        stars.add(new Star(2,2));

        points = new ArrayList<>();
        points.add(new Point(0,7));
        points.add(new Point(1,4));
        points.add(new Point(2,3));

        arena.setCoins(coins);
        arena.setStars(stars);
        arena.setPoints(points);
    }

    @Test
    public void collect_coin(){
        List<Coin> expected = new ArrayList<>();
        int expected2 = 1;
        expected.add(new Coin(1,1));
        expected.add(new Coin(0,3));

        Coin coin_to_remove = new Coin(2,2);

        coin_to_remove.collect(coin_to_remove.getPosition(),arena,arena.getHero());

        Assertions.assertEquals(expected,arena.getCoins());
        Assertions.assertEquals(expected2,arena.getHero().getCollected_coins());
    }

    @Test
    public void remove_star(){
        List<Star> expected = new ArrayList<>();
        int expected2 = 2;
        expected.add(new Star(1,3));

        Star star1_to_remove = new Star(2,2);
        Star star2_to_remove = new Star(0,5);

        star1_to_remove.collect(star1_to_remove.getPosition(),arena,arena.getHero());
        star2_to_remove.collect(star2_to_remove.getPosition(),arena,arena.getHero());

        Assertions.assertEquals(expected,arena.getStars());
        Assertions.assertEquals(expected2,arena.getHero().getCollected_stars());
    }

    @Test
    public void remove_point(){
        List<Point> expected = new ArrayList<>();
        int expected2 = 1;
        expected.add(new Point(0,7));
        expected.add(new Point(1,4));

        Point point_to_remove = new Point(2,3);

        point_to_remove.collect(point_to_remove.getPosition(),arena,arena.getHero());

        Assertions.assertEquals(expected,arena.getPoints());
        Assertions.assertEquals(expected2,arena.getHero().getCollected_points());
    }
}
