package com.aor.tombmask;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.utils.MENU_OPTION;
import com.aor.tombmask.view.MainMenuView;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    private final GUI gui;
    private final Menu menu;
    public Game() throws IOException {
        this.gui = new GUI();
        this.menu = new Menu();
    }

    public void draw() throws IOException {
        gui.clear();
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.draw(gui,menu.getCurrentOption());
        gui.refresh();
    }


    public void run() throws IOException {
        draw();
        while(true) {
            KeyStroke keyStroke = gui.getUserInput();
            ACTION action = gui.getAction(keyStroke);
            if(action.equals(ACTION.DOWN)) menu.downMenu();
            if(action.equals(ACTION.UP)) menu.upMenu();
            if((menu.isSelected(MENU_OPTION.EXIT) && action.equals(ACTION.ENTER)) || action.equals(ACTION.EXIT)) break;
            draw();
        }
        gui.close();
    }
}
