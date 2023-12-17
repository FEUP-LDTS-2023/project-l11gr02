package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.MENU_OPTION;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverControllerTest {
    @Test
    public void testUpAction() throws IOException, InterruptedException {
        GameOver gameOver = Mockito.mock(GameOver.class);
        Game game = Mockito.mock(Game.class);
        GameOverController gameOverController = new GameOverController(gameOver);
        gameOverController.executeState(game, ACTION.UP);

        Mockito.verify(gameOver, Mockito.times(1)).upMenu();
    }
    @Test
    public void testDownAction() throws IOException, InterruptedException {
        GameOver gameOver = Mockito.mock(GameOver.class);
        Game game = Mockito.mock(Game.class);
        GameOverController gameOverController = new GameOverController(gameOver);
        gameOverController.executeState(game, ACTION.DOWN);

        Mockito.verify(gameOver, Mockito.times(1)).downMenu();
    }
    @Test
    public void testEnterAction() throws IOException, InterruptedException {
        GameOver gameOver = Mockito.mock(GameOver.class);
        Game game = Mockito.mock(Game.class);
        GameOverController gameOverController = new GameOverController(gameOver);

        Mockito.when(gameOver.getCurrentOption()).thenReturn(MENU_OPTION.PLAY);
        gameOverController.executeState(game, ACTION.ENTER);

        Mockito.verify(gameOver, Mockito.times(0)).upMenu();
        Mockito.verify(gameOver, Mockito.times(0)).downMenu();
        Mockito.verify(game,Mockito.times(1)).setState(new GameState());
    }

    @Test
    public void testConsumeOptionExit() throws IOException, InterruptedException {
        GameOver gameOver = Mockito.mock(GameOver.class);
        Game game = Mockito.mock(Game.class);
        GameOverController gameOverController = new GameOverController(gameOver);

        Mockito.when(gameOver.getCurrentOption()).thenReturn(MENU_OPTION.EXIT);
        gameOverController.executeState(game, ACTION.ENTER);

        Mockito.verify(gameOver, Mockito.times(0)).upMenu();
        Mockito.verify(gameOver, Mockito.times(0)).downMenu();
        Mockito.verify(game,Mockito.times(1)).setState(new MenuState());
    }
}
