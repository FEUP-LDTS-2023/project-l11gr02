package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DartTest {
    @Test
    public void getDirectionTest() {
        Dart dart = new Dart(0,0, DIRECTION.DOWN);
        Assertions.assertEquals(dart.getDirection(),DIRECTION.DOWN);
    }
    @Test
    public void setDirectionTest() {
        Dart dart = new Dart(0,0, DIRECTION.DOWN);
        dart.setDirection(DIRECTION.UP);
        Assertions.assertEquals(dart.getDirection(),DIRECTION.UP);
    }
}
