package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.GameOverController;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.GameOverView;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class GameOverStateTest {
    @Test
    public void nextStateTest() throws IOException, InterruptedException {
        GUI gui = Mockito.mock(GUI.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        Mockito.when(gui.getUserInput()).thenReturn(keyStroke);
        Mockito.when(gui.getAction(new KeyStroke(KeyType.ArrowDown))).thenReturn(ACTION.DOWN);
        Game game = Mockito.mock(Game.class);

        GameOverView gameOverView = Mockito.mock(GameOverView.class);
        GameOverController gameOverController = Mockito.mock(GameOverController.class);

        GameOverState gameOverState = new GameOverState();
        gameOverState.gameOverController = gameOverController;
        gameOverState.gameOverView = gameOverView;

        gameOverState.nextState(game,gui);

        Mockito.verify(gameOverController,Mockito.times(1)).executeState(Mockito.any(),Mockito.any());
        Mockito.verify(gameOverView,Mockito.times(1)).draw(Mockito.any());
    }
    @Test
    public void equalsTest() {
        GameOverState gameOverState = new GameOverState();
        Assertions.assertEquals(gameOverState, gameOverState);
        Assertions.assertNotEquals(null, gameOverState);
    }
}
