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
        Map<String,String> maskPricesMap = Map.of("AMONGUS","1000","NINJA","2000");
        Mockito.when(store.getAvailableMasks()).thenReturn(List.of("NINJA","AMONGUS"));
        Mockito.when(store.getMaskPriceMap()).thenReturn(maskPricesMap);
        StoreExiter storeExiter = new StoreExiter(store);
        storeExiter.printWriter = Mockito.mock(PrintWriter.class);
        storeExiter.exit();
        Mockito.verify(storeExiter.printWriter,Mockito.times(1)).println("NINJA"+"="+"2000");
        Mockito.verify(storeExiter.printWriter,Mockito.times(1)).println("AMONGUS"+"="+"1000");

    }
}
