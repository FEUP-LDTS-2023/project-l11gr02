package com.dra.tombmask.controller;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Dart;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Wall;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DartControllerTest {

    private DartController dartController;
    private Arena arena;

    @BeforeEach
    void setUp() throws IOException {
        arena = new Arena(30, 30);
        dartController = new DartController(arena);
    }

    @Test
    void testMoveDartLeft() {
        Dart dart = new Dart(new Position(1, 1), DIRECTION.LEFT);
        dartController.moveDart(dart);
        assertEquals(new Position(0, 1), dart.getPosition());
    }

    @Test
    void testMoveDartRight() {
        Dart dart = new Dart(new Position(1, 1), DIRECTION.RIGHT);
        dartController.moveDart(dart);
        assertEquals(new Position(2, 1), dart.getPosition());
    }

    @Test
    void testMoveDartUp() {
        Dart dart = new Dart(new Position(1, 1), DIRECTION.UP);
        dartController.moveDart(dart);
        assertEquals(new Position(1, 0), dart.getPosition());
    }

    @Test
    void testMoveDartDown() {
        Dart dart = new Dart(new Position(1, 1), DIRECTION.DOWN);
        dartController.moveDart(dart);
        assertEquals(new Position(1, 2), dart.getPosition());
    }

    @Test
    void testExecuteState() throws IOException, InterruptedException {
        Game game = Mockito.mock(Game.class);

        Dart dartA = new Dart(3,3, DIRECTION.LEFT);
        Dart dartB = new Dart(2,2, DIRECTION.RIGHT);

        arena.getGlobalElements().add(dartA);
        arena.getDarts().add(dartA);
        arena.getGlobalElements().add(dartB);
        arena.getDarts().add(dartB);

        dartController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,3), arena.getDarts().get(0).getPosition());
        Assertions.assertEquals(new Position(3, 2), arena.getDarts().get(1).getPosition());
    }

    @Test
    void testMoveDartLeftRemovesDartFromLists() {
        Wall wall = new Wall(new Position(1,1));
        Dart dart = new Dart(new Position(2,1), DIRECTION.LEFT);
        arena.getDarts().add(dart);
        arena.getGlobalElements().add(dart);
        arena.getGlobalElements().add(wall);

        int expectedGlobals = arena.getGlobalElements().size();

        Assertions.assertEquals(1, arena.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, arena.getGlobalElements().size());
    }
    @Test
    void testMoveRightDartRemovesDartFromLists() {
        Wall wall = new Wall(new Position(3,1));
        Dart dart = new Dart(new Position(2,1), DIRECTION.RIGHT);
        arena.getDarts().add(dart);
        arena.getGlobalElements().add(dart);
        arena.getGlobalElements().add(wall);

        int expectedGlobals = arena.getGlobalElements().size();

        Assertions.assertEquals(1, arena.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, arena.getGlobalElements().size());
    }
    @Test
    void testMoveDartDownRemovesDartFromLists() {
        Wall wall = new Wall(new Position(2,2));
        Dart dart = new Dart(new Position(2,1), DIRECTION.DOWN);
        arena.getDarts().add(dart);
        arena.getGlobalElements().add(dart);
        arena.getGlobalElements().add(wall);

        int expectedGlobals = arena.getGlobalElements().size();

        Assertions.assertEquals(1, arena.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, arena.getGlobalElements().size());
    }
    @Test
    void testMoveDartUpRemovesDartFromLists() {
        Wall wall = new Wall(new Position(2,1));
        Dart dart = new Dart(new Position(2,2), DIRECTION.UP);
        arena.getDarts().add(dart);
        arena.getGlobalElements().add(dart);
        arena.getGlobalElements().add(wall);

        int expectedGlobals = arena.getGlobalElements().size();

        Assertions.assertEquals(1, arena.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, arena.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, arena.getGlobalElements().size());
    }
}
