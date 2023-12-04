package com.dra.tombmask.utils;

import com.dra.tombmask.model.Store;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class StoreExiterTest {
    @Test
    public void exitTest() throws IOException {
        Store store = Mockito.mock(Store.class);
        Map<String,String> maskPricesMap = Map.of("CROW","1000","AMONGUS","1500","NINJA","2000","DEFAULT","SEL","EXIT","0");
        Mockito.when(store.getAvailableMasks()).thenReturn(List.of("CROW","NINJA","AMONGUS","DEFAULT","EXIT"));
        Mockito.when(store.getMaskPriceMap()).thenReturn(maskPricesMap);
        StoreExiter storeExiter = new StoreExiter(store, "src/main/resources/masks/pricesMasksTest");
        storeExiter.printWriter = Mockito.mock(PrintWriter.class);
        storeExiter.exit();

        Mockito.verify(storeExiter.printWriter,Mockito.times(5)).println(Mockito.any(String.class));
    }
}
