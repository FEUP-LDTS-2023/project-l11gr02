package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.DartTrap;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class DartTrapControllerTest {
    private DartTrapController dartTrapController;
    private Tomb tomb;
    private Game game;

    @BeforeEach
    void setup() throws IOException{
        tomb = new Tomb(30, 30);
        dartTrapController = new DartTrapController(tomb);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testStandbyMode() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.LEFT);
        tomb.getDartTraps().add(trap);
        tomb.getGlobalElements().add(trap);
        trap.setStandby(2);
        dartTrapController.executeState(game, ACTION.NONE);
        Assertions.assertEquals(2-0.08, trap.getStandby());
    }

    @Test
    void testLeftDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.LEFT);

        tomb.getDartTraps().add(trap);
        tomb.getGlobalElements().add(trap);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(1, tomb.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(1,2), tomb.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, tomb.getDartTraps().size());
        Assertions.assertEquals(2, tomb.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testDownDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.DOWN);

        tomb.getDartTraps().add(trap);
        tomb.getGlobalElements().add(trap);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(1, tomb.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,3), tomb.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, tomb.getDartTraps().size());
        Assertions.assertEquals(2, tomb.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testUpDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.UP);

        tomb.getDartTraps().add(trap);
        tomb.getGlobalElements().add(trap);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(1, tomb.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,1), tomb.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, tomb.getDartTraps().size());
        Assertions.assertEquals(2, tomb.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testRightDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.RIGHT);

        tomb.getDartTraps().add(trap);
        tomb.getGlobalElements().add(trap);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(1, tomb.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(3,2), tomb.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, tomb.getDartTraps().size());
        Assertions.assertEquals(2, tomb.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }
}
