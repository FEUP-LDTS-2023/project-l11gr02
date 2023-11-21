package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.utils.*;

import java.io.IOException;

public class MainMenuView extends AbstractMenuView {

    @Override
    public void draw(GUI gui, MENU_OPTION selected) throws IOException {
        gui.drawText(5,5,"SIMPLE TOMB OF THE MASK");
        gui.drawClickable(6,7,"PLAY",selected == MENU_OPTION.PLAY);
        gui.drawClickable(6,9,"EXIT",selected == MENU_OPTION.EXIT);
    }
}
