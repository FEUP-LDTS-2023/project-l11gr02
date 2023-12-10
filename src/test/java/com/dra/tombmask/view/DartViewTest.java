package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Dart;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Spike;
import com.dra.tombmask.utils.DIRECTION;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DartViewTest {
    TextGraphics textGraphics;
    GUI gui;
    DartView testView;
    Dart element;
    @BeforeEach
    public void setup() {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        testView = new DartView();
        element = new Dart(new Position(0,0), DIRECTION.DOWN);
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
