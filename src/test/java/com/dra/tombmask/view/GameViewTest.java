package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Wall;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.text.Element;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;

public class GameViewTest {
    @Test
    public void drawModelTest() throws IOException {
        Arena arena = new Arena(10,10);
        GameView gameView = new GameView(arena);
        CompositeDrawerView compositeDrawerView = Mockito.mock(CompositeDrawerView.class);
        gameView.drawModel(compositeDrawerView);

        Mockito.verify(compositeDrawerView,Mockito.times(2)).draw(Mockito.any(Object.class),Mockito.any());
    }
}
