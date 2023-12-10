package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Hero;
import com.dra.tombmask.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class HeroViewTest {
    TextGraphics textGraphics;
    GUI gui;
    HeroView testView;
    Hero element;
    @BeforeEach
    public void setup() throws IOException {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        testView = new HeroView();
        element = new Hero(new Position(0,0));
    }
    @Test
    public void drawTest2() {
        Screen screen = Mockito.mock(Screen.class);
        Mockito.when(gui.getScreen()).thenReturn(screen);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        testView.draw(element,gui);

        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
}
