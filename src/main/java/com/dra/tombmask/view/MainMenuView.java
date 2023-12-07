package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.utils.MENU_OPTION;

import java.io.IOException;

public class MainMenuView extends AbstractView<Menu> {
    public MainMenuView(Menu menu){
        super(menu);
    }
    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.drawText(1,5,"SIMPLE TOMB OF THE MASK");
        gui.drawSelectable(6,7,"PLAY",getModel().getCurrentOption() == MENU_OPTION.PLAY);
        gui.drawSelectable(6,8,"STORE",getModel().getCurrentOption() == MENU_OPTION.STORE);
        gui.drawSelectable(6,9,"EXIT",getModel().getCurrentOption() == MENU_OPTION.EXIT);
    }
}
