package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StarTest {
    @Test
    public void toStringTest(){
        Star star = new Star(1,1);
        Assertions.assertEquals("(1, 1)",star.toString());
    }
}
