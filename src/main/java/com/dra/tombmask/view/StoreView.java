package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Store;

import java.io.IOException;
import java.util.List;

public class StoreView extends AbstractView<Store> {

    private final List<String> availableMasks;

    public StoreView(Store model) {
        super(model);
        this.availableMasks = getModel().getAvailableMasks();
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.drawText(10,1,"STORE");
        gui.drawText(GUI.WIDTH - 7,1, String.valueOf(getModel().getCurrentCoins()));
        for(int i = 0 ; i < availableMasks.size(); i++) {
            String currentMask = availableMasks.get(i);
            String priceCurrentMask = getModel().getMaskPriceMap().get(currentMask);
            String offset = " ".repeat(15 - currentMask.length() - priceCurrentMask.length());
            if(!currentMask.equals("EXIT"))
                gui.drawBoxSelectable(5,((i+1)*3),
                    currentMask + offset + priceCurrentMask,
                    getModel().isSelected(currentMask));
        }
        gui.drawSelectable(GUI.WIDTH - ("EXIT".length()+ 3),GUI.HEIGHT-1,"EXIT", getModel().isSelected("EXIT"));
    }
}
