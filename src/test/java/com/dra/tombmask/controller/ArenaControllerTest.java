package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArenaControllerTest {
    @Test
    public void executeStateDefaultTest() throws IOException, InterruptedException {
        Game game = Mockito.mock(Game.class);
        Arena arena = new Arena(30,30);
        ArenaController arenaController = new ArenaController(arena);

        Bat bat = new Bat(new Position(3,4), true);
        List<Bat> bats = new ArrayList<>();
        bats.add(bat);
        arena.setBats(bats);

        List<Element> elements =new ArrayList<>();
        elements.add(bat);
        arena.setGlobalElements(elements);

        Mask mask = arena.getMask();
        mask.setPosition(new Position(4,4));
        mask.setDirection(DIRECTION.IDLE);

        arenaController.executeState(game, ACTION.UP);

        Assertions.assertEquals(new Position(4,4),arena.getBats().get(0).getPosition());
        Assertions.assertEquals(new Position(4,0), mask.getPosition());
    }

    @Test
    public void executeStateExitTest() throws IOException, InterruptedException {
        Game game = Mockito.mock(Game.class);
        Arena arena = new Arena(30,30);
        ArenaController arenaController = new ArenaController(arena);

        Bat bat = new Bat(new Position(2,3), true);
        List<Bat> bats = new ArrayList<>();
        bats.add(bat);
        arena.setBats(bats);

        List<Element> elements =new ArrayList<>();
        elements.add(bat);
        arena.setGlobalElements(elements);

        arenaController.executeState(game, ACTION.EXIT);

        Assertions.assertEquals(new Position(3,3),arena.getBats().get(0).getPosition());
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }
}
