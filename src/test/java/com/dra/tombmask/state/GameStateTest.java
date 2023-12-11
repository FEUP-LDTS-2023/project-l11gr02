package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.TombController;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameView;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        Tomb tomb = Mockito.mock(Tomb.class);
        GameView gameView = Mockito.mock(GameView.class);
        TombController tombController = Mockito.mock(TombController.class);

        GameState gameState = new GameState(tomb);
        gameState.tombController = tombController;
        gameState.gameViewer = gameView;

        gameState.nextState(game,gui);

        Mockito.verify(tombController,Mockito.times(1)).executeState(Mockito.any(),Mockito.any());
        Mockito.verify(gameView,Mockito.times(1)).draw(Mockito.any());

    }
}
