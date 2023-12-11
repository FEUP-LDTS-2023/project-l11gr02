package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MaskTest {
    private Mask mask;
    @BeforeEach
    public void setup() throws IOException {
        mask = new Mask(new Position(1,1));
    }

    @Test
    public void collectedCoinsTest(){
        Mask.setCollected_coins(1);
        Assertions.assertEquals(1, Mask.getCollected_coins());
    }

    @Test
    public void collectedPointsTest(){
        Mask.setCollected_points(10);
        Assertions.assertEquals(10, Mask.getCollected_points());
    }

    @Test
    public void collectedStarsTest(){
        Mask.setCollected_stars(3);
        Assertions.assertEquals(3, Mask.getCollected_stars());
    }

    @Test
    public void directionTest(){
        mask.setDirection(DIRECTION.UP);
        Assertions.assertEquals(DIRECTION.UP, mask.getDirection());
    }

    @Test
    public void shieldTimeTest(){
        mask.setShieldedTime(10);
        Assertions.assertEquals(10, mask.getShieldedTime());
        Assertions.assertTrue(mask.isShielded());
    }

    @Test
    public void magnetTest(){
        mask.setMagnetTime(10);
        Assertions.assertTrue(mask.isMagnet());
        Assertions.assertEquals(10, mask.getMagnetTime());
    }
}
