package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void toStringTest(){
        Point point = new Point(1,1);
        Assertions.assertEquals("(1, 1)",point.toString());
    }
}
