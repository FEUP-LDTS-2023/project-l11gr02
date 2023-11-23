package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.utils.*;

import java.io.IOException;

public class MainMenuView extends AbstractView<Menu> {
    public MainMenuView(Menu menu){
        super(menu);
    }
    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.drawText(5,5,"SIMPLE TOMB OF THE MASK");
        gui.drawClickable(6,7,"PLAY",getModel().getCurrentOption() == MENU_OPTION.PLAY);
        gui.drawClickable(6,9,"EXIT",getModel().getCurrentOption() == MENU_OPTION.EXIT);
    }
}
