package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class AbstractViewTest {
    @Test
    public void draw() throws IOException {
        GameView gameView = new GameView(new Arena(0,0));
        GUI gui = Mockito.mock(GUI.class);
        Screen screen = Mockito.mock(Screen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getScreen()).thenReturn(screen);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gameView.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).clear();
        Mockito.verify(gui,Mockito.times(1)).refresh();
    }
}
