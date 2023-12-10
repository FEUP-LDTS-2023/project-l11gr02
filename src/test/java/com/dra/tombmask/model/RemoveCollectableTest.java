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
        arena = new Arena(30,30,"src/main/resources/levels/testlevel");
    }

    @Test
    public void collect_coin(){
        Assertions.assertEquals(5,arena.getCollectables().size());

        Coin coin_to_remove = new Coin(1,2);

        coin_to_remove.collect(arena);

        Assertions.assertEquals(4,arena.getCollectables().size());
    }

    @Test
    public void collect_star(){
        Assertions.assertEquals(5,arena.getCollectables().size());

        Star star1_to_remove = new Star(1,6);
        Star star2_to_remove = new Star(2,6);

        star1_to_remove.collect(arena);
        star2_to_remove.collect(arena);

        Assertions.assertEquals(3,arena.getCollectables().size());
    }

    @Test
    public void collect_point(){
        Assertions.assertEquals(5,arena.getCollectables().size());

        Point point_to_remove = new Point(1,1);

        point_to_remove.collect(arena);

        Assertions.assertEquals(4,arena.getCollectables().size());
    }
}