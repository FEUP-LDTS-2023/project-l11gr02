package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.StoreState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.MENU_OPTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuControllerTest {
    @Test
    public void testUpAction() throws IOException{
        Menu menu = mock(Menu.class);
        Game game = Mockito.mock(Game.class);
        MenuController menuController = new MenuController(menu);

        menuController.executeState(game, ACTION.UP);

        Mockito.verify(menu, Mockito.times(1)).upMenu();
        Mockito.verify(menu, Mockito.times(0)).downMenu();
        Mockito.verify(menu, Mockito.times(0)).getCurrentOption();
    }

    @Test
    public void testDownAction() throws IOException{
        Menu menu = mock(Menu.class);
        Game game = Mockito.mock(Game.class);
        MenuController menuController = new MenuController(menu);

        menuController.executeState(game, ACTION.DOWN);

        Mockito.verify(menu, Mockito.times(0)).upMenu();
        Mockito.verify(menu, Mockito.times(1)).downMenu();
        Mockito.verify(menu, Mockito.times(0)).getCurrentOption();
    }

    @Test
    public void testEnterAction() throws IOException, FontFormatException {
        Menu menu = Mockito.mock(Menu.class);
        Game game = Mockito.mock(Game.class);

        MenuController menuController = new MenuController(menu);

        Mockito.when(game.getCurrentArena()).thenReturn(1);
        Mockito.when(menu.getCurrentOption()).thenReturn(MENU_OPTION.PLAY);

        menuController.executeState(game, ACTION.ENTER);

        Mockito.verify(menu, Mockito.times(0)).upMenu();
        Mockito.verify(menu, Mockito.times(0)).downMenu();

        String path = "src/main/resources/levels/level"+ game.getCurrentArena();
        Mockito.verify(game,Mockito.times(1)).setState(new GameState(new Arena(60,30,path)));
    }

    @Test
    public void testConsumeOptionStore() throws IOException{
        Menu menu = Mockito.mock(Menu.class);
        Game game = Mockito.mock(Game.class);
        StoreState s = new StoreState(new Store());

        MenuController menuController = new MenuController(menu);

        Mockito.when(game.getCurrentArena()).thenReturn(1);
        Mockito.when(menu.getCurrentOption()).thenReturn(MENU_OPTION.STORE);

        menuController.consumeOption(game);

        Mockito.when(game.getState()).thenReturn(s);
    }

    @Test
    public void testConsumeOptionExit() throws IOException{
        Menu menu = Mockito.mock(Menu.class);
        Game game = Mockito.mock(Game.class);

        MenuController menuController = new MenuController(menu);

        Mockito.when(game.getCurrentArena()).thenReturn(1);
        Mockito.when(menu.getCurrentOption()).thenReturn(MENU_OPTION.EXIT);

        menuController.consumeOption(game);

        Mockito.verify(game,Mockito.times(1)).setState(null);
    }
}

