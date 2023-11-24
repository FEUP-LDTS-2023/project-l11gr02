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

import java.io.IOException;

public class GUI {
    static int HEIGHT = 30;
    static int WIDTH = 60;

    private Screen screen;

    public GUI() throws IOException {
        Terminal terminal = createTerminal(WIDTH,HEIGHT);
        this.screen = createScreen(terminal);
    }

    public Terminal createTerminal(int WIDTH, int HEIGHT) throws IOException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public Screen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public void drawWall(Position position) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY())," ");
    }

    public void drawBat(Position position) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY()),"B");
    }

    public void drawHero(Position position) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");
    }

    public void drawSpike(Position position) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY()), "S");
    }

    public void drawText(int x,int y,String message) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        textGraphics.putString(x,y,message);
    }

    public void drawClickable(int x, int y, String message, boolean isSelected) throws IOException {
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
        switch (keyStroke.getKeyType()){
            case ArrowUp -> {
                return ACTION.UP;
            }
            case ArrowDown -> {
                return ACTION.DOWN;
            }
            case ArrowLeft -> {
                return ACTION.LEFT;
            }
            case ArrowRight -> {
                return ACTION.RIGHT;
            }
            case Enter -> {
                return ACTION.ENTER;
            }
            case Escape -> {
                return ACTION.EXIT;
            }
        }
        return ACTION.NONE;
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
