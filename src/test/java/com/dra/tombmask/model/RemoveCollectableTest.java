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
        arena = new Arena(30,30,"src/main/resources/levels/level1");
    }

    @Test
    public void collect_coin(){
    }

    @Test
    public void collect_star(){
    }

    @Test
    public void collect_point(){
    }
    }
