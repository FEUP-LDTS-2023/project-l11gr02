package com.aor.tombmask.GUI;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class AbstractGUI {

    public abstract void drawWall(int x, int y, TextGraphics textGraphics);
    public abstract void drawText(int x, int y, String message, TextGraphics textGraphics);
    
}
