package com.dra.tombmask.utils;

import com.dra.tombmask.model.Store;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreExiter {

    private final Store store;
    private final FileWriter fileWriter;

    public PrintWriter printWriter;

    public StoreExiter(Store model) throws IOException {
        this.store = model;
        this.fileWriter = new FileWriter(Store.pathPricesMasks);
        this.printWriter = new PrintWriter(fileWriter);
    }
    public void exit() throws IOException {
        for(String mask : store.getAvailableMasks()){
            printWriter.println(mask + "=" + store.getMaskPriceMap().get(mask));
        }
        printWriter.println("CURRENT_COINS="+store.getCurrentCoins());
        fileWriter.close();
    }
}
