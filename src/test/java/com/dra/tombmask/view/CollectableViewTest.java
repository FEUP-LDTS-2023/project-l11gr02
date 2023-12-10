package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CollectableViewTest {
    TextGraphics textGraphics;
    GUI gui;
    CollectableView collectableView;
    @BeforeEach
    public void setup() {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        collectableView = new CollectableView();
    }
    @Test
    public void drawCoinTest(){
        collectableView.draw(new Coin(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
    }
    @Test
    public void drawPointTest(){
        collectableView.draw(new Point(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
    }
    @Test
    public void drawStarTest(){
        collectableView.draw(new Star(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
    }
}