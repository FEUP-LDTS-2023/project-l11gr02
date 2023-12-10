package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
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
    private Arena arena;
    private Game game;

    @BeforeEach
    void setup() throws IOException{
        arena = new Arena(30, 30);
        dartTrapController = new DartTrapController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testStandbyMode() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.LEFT);
        arena.getDartTraps().add(trap);
        arena.getGlobalElements().add(trap);
        trap.setStandby(2);
        dartTrapController.executeState(game, ACTION.NONE);
        Assertions.assertEquals(2-0.08, trap.getStandby());
    }

    @Test
    void testLeftDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.LEFT);

        arena.getDartTraps().add(trap);
        arena.getGlobalElements().add(trap);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(1, arena.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(1,2), arena.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, arena.getDartTraps().size());
        Assertions.assertEquals(2, arena.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testDownDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.DOWN);

        arena.getDartTraps().add(trap);
        arena.getGlobalElements().add(trap);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(1, arena.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,3), arena.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, arena.getDartTraps().size());
        Assertions.assertEquals(2, arena.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testUpDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.UP);

        arena.getDartTraps().add(trap);
        arena.getGlobalElements().add(trap);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(1, arena.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,1), arena.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, arena.getDartTraps().size());
        Assertions.assertEquals(2, arena.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }

    @Test
    void testRightDartTrap() throws IOException, InterruptedException {
        DartTrap trap = new DartTrap(new Position(2,2), DIRECTION.RIGHT);

        arena.getDartTraps().add(trap);
        arena.getGlobalElements().add(trap);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(1, arena.getGlobalElements().size());

        dartTrapController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(3,2), arena.getDarts().get(0).getPosition());
        Assertions.assertEquals(1, arena.getDartTraps().size());
        Assertions.assertEquals(2, arena.getGlobalElements().size());
        Assertions.assertEquals(2, trap.getStandby());
    }
}
