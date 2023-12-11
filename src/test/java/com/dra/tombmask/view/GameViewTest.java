package com.dra.tombmask.view;

import com.dra.tombmask.model.Tomb;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;

public class GameViewTest {
    @Test
    public void drawModelTest() throws IOException {
        Tomb tomb = new Tomb(10,10);
        GameView gameView = new GameView(tomb);
        CompositeDrawerView compositeDrawerView = Mockito.mock(CompositeDrawerView.class);
        gameView.drawModel(compositeDrawerView);

        Mockito.verify(compositeDrawerView,Mockito.times(2)).draw(Mockito.any(Object.class),Mockito.any());
    }
}
