package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void setXAndYTest(){
        Position position = new Position(1,1);
        position.setX(2);
        position.setY(3);

        Assertions.assertEquals(2,position.getX());
        Assertions.assertEquals(3,position.getY());
    }

    @Test
    public void toStringTest(){
        Position position = new Position(1,1);
        Assertions.assertEquals("(1, 1)",position.toString());
    }
}
