package com.dra.tombmask.state;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.controller.StoreController;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.view.StoreView;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowLeft;

public class StoreStateTest {
    @Test
    public void nextStateTest() throws IOException, InterruptedException {
        GUI gui = Mockito.mock(GUI.class);
        KeyStroke keyStroke = new KeyStroke(ArrowLeft);
        Mockito.when(gui.getUserInput()).thenReturn(keyStroke);
        Mockito.when(gui.getAction(new KeyStroke(ArrowLeft))).thenReturn(ACTION.LEFT);
        Game game = Mockito.mock(Game.class);

        Store store = Mockito.mock(Store.class);
        StoreView storeView = Mockito.mock(StoreView.class);
        StoreController storeController = Mockito.mock(StoreController.class);

        StoreState storeState = new StoreState();
        storeState.storeController = storeController;
        storeState.storeView = storeView;

        storeState.nextState(game,gui);

        Mockito.verify(storeController,Mockito.times(1)).executeState(Mockito.any(),Mockito.any());
        Mockito.verify(storeView,Mockito.times(1)).draw(Mockito.any());

    }
}
