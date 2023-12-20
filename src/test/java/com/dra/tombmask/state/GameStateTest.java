package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.ArenaController;
import com.dra.tombmask.controller.StoreController;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameView;
import com.dra.tombmask.view.StoreView;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowLeft;

public class GameStateTest {
    @Test
    public void nextStateTest() throws IOException, InterruptedException {
        GUI gui = Mockito.mock(GUI.class);
        KeyStroke keyStroke = new KeyStroke(ArrowLeft);
        Mockito.when(gui.getUserInput()).thenReturn(keyStroke);
        Mockito.when(gui.getAction(new KeyStroke(ArrowLeft))).thenReturn(ACTION.LEFT);
        Game game = Mockito.mock(Game.class);

        GameView gameView = Mockito.mock(GameView.class);
        ArenaController arenaController = Mockito.mock(ArenaController.class);

        GameState gameState = new GameState();
        gameState.arenaController = arenaController;
        gameState.gameViewer = gameView;

        gameState.nextState(game,gui);

        Mockito.verify(arenaController,Mockito.times(1)).executeState(Mockito.any(),Mockito.any());
        Mockito.verify(gameView,Mockito.times(1)).draw(Mockito.any());

        Assertions.assertTrue(gameState.equals(gameState));
        Assertions.assertFalse(gameState.equals(null));
    }
}
