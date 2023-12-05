package com.dra.tombmask.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveCollectableTest {
    private Arena arena;

    @BeforeEach
    public void setup() throws IOException {
        arena = new Arena(30,30,"src/main/resources/levels/level1");
    }

    @Test
    public void collect_coin(){
        List<Collectable> expected = new ArrayList<>();
        expected.add(new Coin(1,1));
        expected.add(new Coin(8,1));

        Coin coin_to_remove = new Coin(1,8);

        coin_to_remove.collect(arena);

        Assertions.assertEquals(expected,arena.getCollectables());
    }

    @Test
    public void collect_star(){
        List<Collectable> collectables = new ArrayList<>();
        collectables.add(new Star(0,5));
        collectables.add(new Coin(1,1));
        collectables.add(new Star(1,3));
        collectables.add(new Coin(1,8));
        collectables.add(new Star(2,2));
        collectables.add(new Coin(8,1));

        arena.setCollectables(collectables);

        List<Collectable> expected = new ArrayList<>();
        expected.add(new Coin(1,1));
        expected.add(new Star(1,3));
        expected.add(new Coin(1,8));
        expected.add(new Coin(8,1));

        Star star1_to_remove = new Star(2,2);
        Star star2_to_remove = new Star(0,5);

        star1_to_remove.collect(arena);
        star2_to_remove.collect(arena);

        Assertions.assertEquals(expected,arena.getCollectables());
    }

    @Test
    public void collect_point(){
        List<Collectable> collectables = new ArrayList<>();
        collectables.add(new Point(0,7));
        collectables.add(new Coin(1,1));
        collectables.add(new Point(1,4));
        collectables.add(new Coin(1,8));
        collectables.add(new Point(2,3));
        collectables.add(new Coin(8,1));

        arena.setCollectables(collectables);

        List<Collectable> expected = new ArrayList<>();
        expected.add(new Point(0,7));
        expected.add(new Coin(1,1));
        expected.add(new Point(1,4));
        expected.add(new Coin(1,8));
        expected.add(new Coin(8,1));

        Point point_to_remove = new Point(2,3);

        point_to_remove.collect(arena);

        Assertions.assertEquals(expected,arena.getCollectables());
    }
}