package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.MenuController;
import com.dra.tombmask.controller.StoreController;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.MainMenuView;
import com.dra.tombmask.view.StoreView;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowLeft;

public class MenuStateTest {
    @Test
    public void nextStateTest() throws IOException, InterruptedException {
        GUI gui = Mockito.mock(GUI.class);
        KeyStroke keyStroke = new KeyStroke(ArrowLeft);
        Mockito.when(gui.getUserInput()).thenReturn(keyStroke);
        Mockito.when(gui.getAction(new KeyStroke(ArrowLeft))).thenReturn(ACTION.LEFT);
        Game game = Mockito.mock(Game.class);

        MainMenuView mainMenuView = Mockito.mock(MainMenuView.class);
        MenuController menuController = Mockito.mock(MenuController.class);

        MenuState menuState = new MenuState();
        menuState.menuController = menuController;
        menuState.mainMenuView = mainMenuView;

        menuState.nextState(game,gui);

        Mockito.verify(menuController,Mockito.times(1)).executeState(Mockito.any(),Mockito.any());
        Mockito.verify(mainMenuView,Mockito.times(1)).draw(Mockito.any());

    }
}
