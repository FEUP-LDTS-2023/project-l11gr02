package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Store;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StoreTets {
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
    }
}
