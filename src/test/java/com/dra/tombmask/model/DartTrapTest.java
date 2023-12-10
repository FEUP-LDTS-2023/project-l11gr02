package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DartTrapTest {
    @Test
    public void inStandByTest() {
        DartTrap dartTrap = new DartTrap(0,0, DIRECTION.DOWN);
        Assertions.assertFalse(dartTrap.inStandby());
    }
    @Test
    public void getStandByTest() {
        DartTrap dartTrap = new DartTrap(0,0, DIRECTION.DOWN);
        Assertions.assertEquals(dartTrap.getStandby(),0);
    }
    @Test
    public void setStandByTest() {
        DartTrap dartTrap = new DartTrap(0,0,DIRECTION.DOWN);
        dartTrap.setStandby(10);
        Assertions.assertEquals(dartTrap.getStandby(),10);
    }
    @Test
    public void getDirectionTest() {
        DartTrap dartTrap = new DartTrap(0,0,DIRECTION.DOWN);
        Assertions.assertEquals(dartTrap.getDirection(),DIRECTION.DOWN);
    }
}
