package com.dra.tombmask.utils;

import com.dra.tombmask.model.Store;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreExiter {

    private final Store store;
    public PrintWriter printWriter;

    public String path;

    public StoreExiter(Store model, String path) throws IOException {
        this.store = model;
        this.path = path;
    }
    public void exit() throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        this.printWriter = new PrintWriter(fileWriter);
        for(String mask : store.getAvailableMasks()){
            printWriter.println(mask + "=" + store.getMaskPriceMap().get(mask));
        }
        printWriter.println("CURRENT_COINS="+store.getCurrentCoins());
        fileWriter.close();
    }
}
