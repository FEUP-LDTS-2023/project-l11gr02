package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.GameOver;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverViewTest {
    @Test
    public void drawTest() throws IOException {
        GameOver gameOver = new GameOver();
        GameOverView gameOverView = new GameOverView(gameOver);
        GUI gui = Mockito.mock(GUI.class);
        gameOverView.draw(gui);

        Mockito.verify(gui,Mockito.times(1))
                .drawText(Mockito.any(Integer.class),Mockito.any(Integer.class),Mockito.anyString());
        Mockito.verify(gui,Mockito.times(2))
                .drawSelectable(Mockito.any(Integer.class),Mockito.any(Integer.class),Mockito.anyString(),Mockito.any(Boolean.class));
    }
}
