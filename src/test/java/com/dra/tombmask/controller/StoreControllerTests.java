
package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.StoreExiterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class StoreControllerTests {
    private Store store;
    private Game game;
    private StoreController storeController;
    @BeforeEach
    public void setup() throws IOException, FontFormatException {
        store = Mockito.mock(Store.class);
        game = new Game();
        storeController = new StoreController(store);
    }
    @Test
    public void onceUpTest() throws IOException, InterruptedException {
        storeController.executeState(game, ACTION.UP);
        Mockito.verify(store,Mockito.times(1)).upMenu();
    }
    @Test
    public void onceDownTest() throws IOException, InterruptedException {
        storeController.executeState(game,ACTION.DOWN);
        Mockito.verify(store,Mockito.times(1)).downMenu();
    }
    @Test
    public void enterExitTest() throws IOException, InterruptedException {
        Mockito.when(store.getCurrentMask()).thenReturn("EXIT");
        storeController.storeExiter = Mockito.mock(com.dra.tombmask.utils.StoreExiter.class);
        storeController.executeState(game,ACTION.ENTER);
        Mockito.verify(storeController.storeExiter,Mockito.times(1)).exit();
    }
    @Test
    public void exitTest() throws IOException, InterruptedException {
        storeController.storeExiter = Mockito.mock(com.dra.tombmask.utils.StoreExiter.class);
        storeController.executeState(game,ACTION.EXIT);
        Mockito.verify(storeController.storeExiter,Mockito.times(1)).exit();
    }
    @Test
    public void multipleMovesTest() throws IOException, InterruptedException {
        storeController.executeState(game,ACTION.DOWN);
        storeController.executeState(game,ACTION.DOWN);
        storeController.executeState(game,ACTION.UP);
        storeController.executeState(game,ACTION.DOWN);
        Mockito.verify(store,Mockito.times(3)).downMenu();
        Mockito.verify(store,Mockito.times(1)).upMenu();
    }
    @Test
    public void consumeOptionSelectTest() throws IOException {
        store = Mockito.mock(Store.class);
        storeController = new StoreController(store);
        String mask = "NINJA";
        Mockito.when(store.getOwnedMasks()).thenReturn(java.util.List.of("NINJA","DEFAULT"));
        storeController.consumeOption(mask);
        Mockito.verify(store,Mockito.times(1)).selectMask(mask);
    }
    @Test
    public void consumeOptionBuyTest() throws IOException {
        store = Mockito.mock(Store.class);
        storeController = new StoreController(store);
        String mask = "NINJA";
        Mockito.when(store.getOwnedMasks()).thenReturn(List.of("DEFAULT"));
        storeController.consumeOption(mask);
        Mockito.verify(store,Mockito.times(1)).buyMask(mask);
    }
}

