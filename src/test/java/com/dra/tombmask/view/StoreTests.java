package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Store;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.eq;

public class StoreTests {
    @Test
    public void drawStore() throws IOException {
        GUI gui = Mockito.mock(GUI.class);
        Store store = Mockito.mock(Store.class);
        List<String> availableMasks = List.of("AMONGUS","NINJA");
        Map<String,String> maskPricesMap = Map.of("AMONGUS","1000","NINJA","2000");
        Mockito.when(store.getAvailableMasks()).thenReturn(availableMasks);
        Mockito.when(store.getMaskPriceMap()).thenReturn(maskPricesMap);
        StoreView storeView = new StoreView(store);
        storeView.drawModel(gui);
        Mockito.verify(gui,Mockito.times(1)).drawText(10,1,"STORE");
        Mockito.verify(gui,Mockito.times(1)).drawText(GUI.WIDTH - 7,1,"0");
        Mockito.verify(gui,Mockito.times(availableMasks.size())).drawBoxSelectable(
                Mockito.any(Integer.class),Mockito.any(Integer.class),Mockito.any(String.class),Mockito.any(boolean.class));
        Mockito.verify(gui,Mockito.times(1)).drawSelectable(
                eq(GUI.WIDTH - ("EXIT".length()+ 3)),eq(GUI.HEIGHT-1),eq("EXIT"),Mockito.any(boolean.class));
    }
}
