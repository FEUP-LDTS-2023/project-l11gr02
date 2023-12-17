package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void symbolTest(){
        Point point = new Point(0,0);
        Assertions.assertEquals(point.getSymbol(),"p");
    }
    @Test
    public void toStringTest(){
        Point point = new Point(1,1);
        Assertions.assertEquals("(1, 1)",point.toString());
    }
}
