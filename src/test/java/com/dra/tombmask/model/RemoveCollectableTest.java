package com.dra.tombmask.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class RemoveCollectableTest {
    private Tomb tomb;

    @BeforeEach
    public void setup() throws IOException {
        tomb = new Tomb(30,30,"src/main/resources/levels/testlevel");
    }

    @Test
    public void collect_coin(){
        Assertions.assertEquals(5, tomb.getCollectables().size());

        Coin coin_to_remove = new Coin(1,2);

        coin_to_remove.collect(tomb);

        Assertions.assertEquals(4, tomb.getCollectables().size());
    }

    @Test
    public void collect_star(){
        Assertions.assertEquals(5, tomb.getCollectables().size());

        Star star1_to_remove = new Star(1,6);
        Star star2_to_remove = new Star(2,6);

        star1_to_remove.collect(tomb);
        star2_to_remove.collect(tomb);

        Assertions.assertEquals(3, tomb.getCollectables().size());
    }

    @Test
    public void collect_point(){
        Assertions.assertEquals(5, tomb.getCollectables().size());

        Point point_to_remove = new Point(1,1);

        point_to_remove.collect(tomb);

        Assertions.assertEquals(4, tomb.getCollectables().size());
    }
}