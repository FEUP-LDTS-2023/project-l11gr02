package com.dra.tombmask.GUI;

import com.dra.tombmask.model.Position;
import com.dra.tombmask.utils.ACTION;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GUI {
    static int HEIGHT = 12;
    static int WIDTH = 30;

    private Screen screen;

    public GUI() throws IOException, FontFormatException {
        Terminal terminal = createTerminal(WIDTH,HEIGHT,loadFont());
        this.screen = createScreen(terminal);
    }

    public Screen getScreen() {
        return this.screen;
    }

    public Terminal createTerminal(int WIDTH, int HEIGHT, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        return terminalFactory.createTerminal();
    }

    public AWTTerminalFontConfiguration loadFont() throws IOException, FontFormatException {
        File file = new File("./src/main/resources/fonts/font.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT,file);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN,40);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public Screen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public void drawText(int x,int y,String message) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(x,y,message);
    }

    public void drawSelectable(int x, int y, String message, boolean isSelected) throws IOException {
        if(isSelected) {
            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
            textGraphics.putString(x,y,"> ");
        }
        drawText(x+2,y,message);
    }


    public KeyStroke getUserInput() throws IOException {
        return screen.pollInput();
    }

    public ACTION getAction(KeyStroke keyStroke) {
        if(keyStroke == null) return ACTION.NONE;
        return switch (keyStroke.getKeyType()) {
            case ArrowUp -> ACTION.UP;
            case ArrowDown -> ACTION.DOWN;
            case ArrowLeft -> ACTION.LEFT;
            case ArrowRight -> ACTION.RIGHT;
            case Enter -> ACTION.ENTER;
            case Escape -> ACTION.EXIT;
            default -> ACTION.NONE;
        };
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }
}
