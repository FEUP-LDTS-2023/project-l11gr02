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
        Assertions.assertEquals(20,arena.getCollectables().size());

        Coin coin_to_remove = new Coin(1,4);

        coin_to_remove.collect(arena);

        Assertions.assertEquals(19,arena.getCollectables().size());
    }

    @Test
    public void collect_star(){
        Assertions.assertEquals(20,arena.getCollectables().size());

        Star star1_to_remove = new Star(1,2);
        Star star2_to_remove = new Star(3,8);

        star1_to_remove.collect(arena);
        star2_to_remove.collect(arena);

        Assertions.assertEquals(18,arena.getCollectables().size());
    }

    @Test
    public void collect_point(){
        Assertions.assertEquals(20,arena.getCollectables().size());

        Point point_to_remove = new Point(1,1);

        point_to_remove.collect(arena);

        Assertions.assertEquals(19,arena.getCollectables().size());
    }
}