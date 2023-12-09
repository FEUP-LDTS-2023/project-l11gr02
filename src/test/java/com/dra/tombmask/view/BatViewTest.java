package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Bat;
import com.dra.tombmask.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class BatViewTest {
    TextGraphics textGraphics;
    GUI gui;
    BatView batView;
    Bat bat;
    @BeforeEach
    public void setup() {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        batView = new BatView();
        bat = new Bat(new Position(0,0),Boolean.FALSE);
    }
    @Test
    public void drawTest() {
        batView.draw(bat,gui,textGraphics);
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
}
