package com.dra.tombmask.model;

import com.dra.tombmask.utils.MENU_OPTION;

import java.util.Arrays;
import java.util.List;


public class Menu {
    private final List<MENU_OPTION> listOptions;
    private int currentIndex;
    public Menu() {
        this.currentIndex = 0;
        this.listOptions = Arrays.asList(MENU_OPTION.PLAY,MENU_OPTION.STORE,MENU_OPTION.EXIT);
    }
    public void upMenu() {
        currentIndex--;
        if(currentIndex < 0) currentIndex = listOptions.size() - 1;
    }
    public void downMenu() {
        currentIndex++;
        if(currentIndex > listOptions.size() - 1) currentIndex = 0;
    }

    public MENU_OPTION getCurrentOption() {
        return listOptions.get(currentIndex);
    }

    public boolean isSelected(MENU_OPTION value) {
        return value == getCurrentOption();
    }
}
