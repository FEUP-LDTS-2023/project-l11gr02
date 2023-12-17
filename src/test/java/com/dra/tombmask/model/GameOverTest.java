package com.dra.tombmask.model;

import com.dra.tombmask.utils.MENU_OPTION;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOverTest {
    @Test
    public void moveTest(){
        GameOver gameOver = new GameOver();
        Assertions.assertEquals(gameOver.getCurrentOption(), MENU_OPTION.PLAY);
        Assertions.assertTrue(gameOver.isSelected(MENU_OPTION.PLAY));

        gameOver.upMenu();
        Assertions.assertEquals(gameOver.getCurrentOption(),MENU_OPTION.EXIT);

        gameOver.downMenu();
        Assertions.assertEquals(gameOver.getCurrentOption(),MENU_OPTION.PLAY);
    }
}
