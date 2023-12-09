package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeroTest {
    private Hero hero;
    @BeforeEach
    public void setup(){
        hero = new Hero(new Position(1,1));
    }

    @Test
    public void collectedCoinsTest(){
        Hero.setCollected_coins(1);
        Assertions.assertEquals(1,Hero.getCollected_coins());
    }

    @Test
    public void collectedPointsTest(){
        Hero.setCollected_points(10);
        Assertions.assertEquals(10,Hero.getCollected_points());
    }

    @Test
    public void collectedStarsTest(){
        Hero.setCollected_stars(3);
        Assertions.assertEquals(3,Hero.getCollected_stars());
    }

    @Test
    public void directionTest(){
        hero.setDirection(DIRECTION.UP);
        Assertions.assertEquals(DIRECTION.UP,hero.getDirection());
    }

    @Test
    public void shieldTimeTest(){
        hero.setShieldedTime(10);
        Assertions.assertEquals(10,hero.getShieldedTime());
        Assertions.assertTrue(hero.isShielded());
    }

    @Test
    public void magnetTest(){
        hero.setMagnetTime(10);
        Assertions.assertTrue(hero.isMagnet());
        Assertions.assertEquals(10,hero.getMagnetTime());
    }
}
