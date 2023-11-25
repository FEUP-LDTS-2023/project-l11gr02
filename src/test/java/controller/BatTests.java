package controller;

import com.dra.tombmask.model.Bat;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatTests {
    @Test
    public void directionRightTest() {
        Bat bat = new Bat(3,4,true);
        assertEquals(bat.getDirection(), DIRECTION.RIGHT);
    }
    @Test
    public void directionLeftTest() {
        Bat bat = new Bat(4,3,false);
        assertEquals(bat.getDirection(),DIRECTION.LEFT);
    }
}
