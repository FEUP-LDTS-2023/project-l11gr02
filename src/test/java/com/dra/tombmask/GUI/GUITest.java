package com.dra.tombmask.GUI;

import com.dra.tombmask.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

public class GUITest {
    private Screen screen;
    private GUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setup() throws IOException, FontFormatException {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new GUI(screen);
    }

    @Test
    void draw_hero(){
        gui.drawHero(new Position(1,1),false);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(1,1), "h");
    }

    @Test
    void draw_wall(){
        gui.drawWall(new Position(1,2));

        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(153, 51, 153));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(1,2), " ");
    }

    @Test
    void draw_bat(){
        gui.drawBat(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(1,1), "b");
    }

    @Test
    void draw_spike(){
        gui.drawSpike(new Position(4,4));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(4,4), "t");
    }

    @Test
    void draw_endLevel(){
        gui.drawEndLevel(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(1,1), "e");
    }

    @Test
    void draw_text() {
        gui.drawText(1,1, "Hello World");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}
