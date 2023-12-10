package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.*;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.FreezeStrategyTest;
import com.dra.tombmask.utils.CORNER;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MiscViewTest {
    TextGraphics textGraphics;
    GUI gui;
    MiscView miscView;
    @BeforeEach
    public void setup() {
        textGraphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        miscView = new MiscView();
    }
    @Test
    public void drawCoinTest(){
        miscView.draw(new Coin(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
    @Test
    public void drawPointTest(){
        miscView.draw(new Point(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
    @Test
    public void drawStarTest(){
        miscView.draw(new Star(0,0),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
    @Test
    public void drawTrampolineTest(){
        miscView.draw(new Trampoline(new Position(0,0), CORNER.TOPLEFT),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }

    @Test
    public void drawPowerUpTest(){
        miscView.draw(new PowerUp(new Position(0,0), new FreezeStrategy()),gui,textGraphics);

        Mockito.verify(textGraphics,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(textGraphics,Mockito.times(1)).putString(Mockito.any(),Mockito.any());
    }
}