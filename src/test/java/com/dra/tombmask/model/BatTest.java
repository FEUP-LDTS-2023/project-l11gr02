package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BatTest {
    @Test
    public void timeoutFailTest(){
        Bat bat = new Bat(1,1,true);
        bat.setTimeout(-1);

        Assertions.assertEquals(0,bat.getTimeout());
    }

    @Test
    public void timeoutSuccessTest(){
        Bat bat = new Bat(1,1,true);
        bat.setTimeout(3);

        Assertions.assertEquals(3,bat.getTimeout());
    }

    @Test
    public void directionTest(){
        Bat bat = new Bat(1,1,true);

        Assertions.assertEquals(DIRECTION.RIGHT,bat.getDirection());

        bat.setDirection(DIRECTION.LEFT);

        Assertions.assertEquals(DIRECTION.LEFT,bat.getDirection());
    }
}
