package com.dra.tombmask.GUI;

import com.dra.tombmask.model.Element;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.Wall;
import com.dra.tombmask.utils.ACTION;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

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
    public void draw_text() {
        gui.drawText(1,1, "Hello World");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }
    @Test
    public void userInputUPTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        assertEquals(gui.getAction(keyStroke), ACTION.UP);
    }

    @Test
    public void userInputDOWNTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        assertEquals(gui.getAction(keyStroke), ACTION.DOWN);
    }

    @Test
    public void userInputLEFTTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        assertEquals(gui.getAction(keyStroke), ACTION.LEFT);
    }

    @Test
    public void userInputRIGHTTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        assertEquals(gui.getAction(keyStroke), ACTION.RIGHT);
    }

    @Test
    public void userInputEXITTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        assertEquals(gui.getAction(keyStroke), ACTION.EXIT);
    }

    @Test
    public void userInputSELECTTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        assertEquals(gui.getAction(keyStroke), ACTION.ENTER);
    }

    @Test
    public void userInputUNKNOWNTest(){
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Unknown);
        assertEquals(gui.getAction(keyStroke), ACTION.NONE);
    }

    @Test
    public void userInputNULLTest(){
        KeyStroke keyStroke = null;
        assertEquals(gui.getAction(keyStroke), ACTION.NONE);
    }

    @Test
    public void draw_boxSelectable() throws IOException{
        gui.drawBoxSelectable(3,3,"Clicked",true);

        Mockito.verify(textGraphics, Mockito.times(4)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(3, 3, "---------");
        Mockito.verify(textGraphics, Mockito.times(4)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 4, "> ");
        Mockito.verify(textGraphics, Mockito.times(4)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(3, 5, "---------");
    }

    @Test
    public void draw_selectable1() throws IOException{
        gui.drawSelectable(1,1, "Hello World",true);

        Mockito.verify(textGraphics, Mockito.times(2)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "> ");
    }

    @Test
    public void draw_selectable2() throws IOException{
        gui.drawSelectable(1,1, "Hello World",false);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(3, 1, "Hello World");
    }

    @Test
    public void screenTest(){
        Assertions.assertEquals(screen,gui.getScreen());
    }
}
