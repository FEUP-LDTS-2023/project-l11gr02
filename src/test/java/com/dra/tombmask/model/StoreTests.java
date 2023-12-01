package com.dra.tombmask.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreTests {
    private Store store;
    @BeforeEach
    public void setup() throws IOException {
        store = new Store();
        store = new Store("src/main/resources/masks/pricesMasksTest");
    }
    @Test
    public void upMenuTest() {
        store.upMenu();
        assertEquals(store.getAvailableMasks().size()-1,store.getCurrentIndex());
        store.upMenu();
        assertEquals(store.getAvailableMasks().size()-2,store.getCurrentIndex());
    }
    @Test
    public void downMenuTest() {
        store.downMenu();
        assertEquals(1,store.getCurrentIndex());
        store.downMenu();
        assertEquals(store.getAvailableMasks().get(2),store.getCurrentMask());
    }
    @Test
    public void selectMaskTest() {
        store.selectMask("CROW");
        assertTrue(store.isSelected("CROW"));
        assertEquals("CROW",store.getSelectedMask());
    }
    @Test
    public void buyMaskTest() {
        store.setCurrentCoins(100000000);
        int currentCoins = store.getCurrentCoins();
        store.buyMask("NINJA");
        assertTrue(store.getOwnedMasks().contains("NINJA"));
        assertEquals(currentCoins-2000,store.getCurrentCoins());
    }
}
