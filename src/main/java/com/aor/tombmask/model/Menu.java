package com.aor.tombmask.model;

import com.aor.tombmask.utils.MENU_OPTION;

public class Menu {
    private MENU_OPTION currentOption;

    
    public Menu() {
        this.currentOption = MENU_OPTION.PLAY;
    }
    public void upMenu() {
        currentOption = MENU_OPTION.PLAY;
    }
    public void downMenu() {
        currentOption = MENU_OPTION.EXIT;
    }

    public MENU_OPTION getCurrentOption() {
        return currentOption;
    }

    public boolean isSelected(MENU_OPTION value) {
        return value == currentOption;
    }
}
