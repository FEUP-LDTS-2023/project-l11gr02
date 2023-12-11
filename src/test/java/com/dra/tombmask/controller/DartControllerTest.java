package com.dra.tombmask.controller;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Tomb;
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

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DartControllerTest {

    private DartController dartController;
    private Tomb tomb;

    @BeforeEach
    void setUp() throws IOException {
        tomb = new Tomb(30, 30);
        dartController = new DartController(tomb);
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

        tomb.getGlobalElements().add(dartA);
        tomb.getDarts().add(dartA);
        tomb.getGlobalElements().add(dartB);
        tomb.getDarts().add(dartB);

        dartController.executeState(game, ACTION.NONE);

        Assertions.assertEquals(new Position(2,3), tomb.getDarts().get(0).getPosition());
        Assertions.assertEquals(new Position(3, 2), tomb.getDarts().get(1).getPosition());
    }

    @Test
    void testMoveDartLeftRemovesDartFromLists() {
        Wall wall = new Wall(new Position(1,1));
        Dart dart = new Dart(new Position(2,1), DIRECTION.LEFT);
        tomb.getDarts().add(dart);
        tomb.getGlobalElements().add(dart);
        tomb.getGlobalElements().add(wall);

        int expectedGlobals = tomb.getGlobalElements().size();

        Assertions.assertEquals(1, tomb.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, tomb.getGlobalElements().size());
    }
    @Test
    void testMoveRightDartRemovesDartFromLists() {
        Wall wall = new Wall(new Position(3,1));
        Dart dart = new Dart(new Position(2,1), DIRECTION.RIGHT);
        tomb.getDarts().add(dart);
        tomb.getGlobalElements().add(dart);
        tomb.getGlobalElements().add(wall);

        int expectedGlobals = tomb.getGlobalElements().size();

        Assertions.assertEquals(1, tomb.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, tomb.getGlobalElements().size());
    }
    @Test
    void testMoveDartDownRemovesDartFromLists() {
        Wall wall = new Wall(new Position(2,2));
        Dart dart = new Dart(new Position(2,1), DIRECTION.DOWN);
        tomb.getDarts().add(dart);
        tomb.getGlobalElements().add(dart);
        tomb.getGlobalElements().add(wall);

        int expectedGlobals = tomb.getGlobalElements().size();

        Assertions.assertEquals(1, tomb.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, tomb.getGlobalElements().size());
    }
    @Test
    void testMoveDartUpRemovesDartFromLists() {
        Wall wall = new Wall(new Position(2,1));
        Dart dart = new Dart(new Position(2,2), DIRECTION.UP);
        tomb.getDarts().add(dart);
        tomb.getGlobalElements().add(dart);
        tomb.getGlobalElements().add(wall);

        int expectedGlobals = tomb.getGlobalElements().size();

        Assertions.assertEquals(1, tomb.getDarts().size());

        dartController.moveDart(dart);

        Assertions.assertEquals(0, tomb.getDarts().size());
        Assertions.assertEquals(expectedGlobals-1, tomb.getGlobalElements().size());
    }
}
