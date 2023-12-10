package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Wall;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

public class GameViewTest {
    @Test
    public void drawSingle() throws IOException {
        Arena arena = new Arena(10,10);
        GameView gameView = new GameView(arena);
        GUI gui = Mockito.mock(GUI.class);
        WallView wallView = Mockito.mock(WallView.class);
        Wall wall = new Wall(0,0);
        gameView.drawGame(gui,wall,wallView);

        Mockito.verify(wallView,Mockito.times(1)).draw(eq(wall),eq(gui));
    }
    @Test
    public void drawList() throws IOException {
        Arena arena = new Arena(10,10);
        GameView gameView = new GameView(arena);
        GUI gui = Mockito.mock(GUI.class);
        WallView wallView = Mockito.mock(WallView.class);
        List<Wall> wallList =Arrays.asList(new Wall(0,0),new Wall(1,1),new Wall(2,2));
        gameView.drawGame(gui,wallList,wallView);
        Mockito.verify(wallView,Mockito.times(3)).draw(Mockito.any(Wall.class),Mockito.any(GUI.class));
    }
}
