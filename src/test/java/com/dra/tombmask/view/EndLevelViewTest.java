package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.EndLevel;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EndLevelViewTest {
    TextGraphics textGraphics;
    GUI gui;
    EndLevelView testView;
    EndLevel element;
    @BeforeEach
    public void setup() {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        testView = new EndLevelView();
        element = new EndLevel(0,0);
    }
    @Test
    public void drawTest() {
        testView.draw(element,gui,textGraphics);
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
}
