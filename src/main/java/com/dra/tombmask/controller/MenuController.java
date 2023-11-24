package com.dra.tombmask.controller;
import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.MENU_OPTION;

import java.io.IOException;

public class MenuController extends AbstractController<Menu>{
    public MenuController(Menu menu){
        super(menu);
    }

    @Override
    public void executeState(Game game, ACTION action, GUI gui) throws IOException {
        switch (action){
            case UP:
                getModel().upMenu();
                break;
            case DOWN:
                getModel().downMenu();
                break;
            case ENTER:
                if(getModel().isSelected(MENU_OPTION.PLAY)) { game.setState(new GameState(new Arena(60, 30, "docs/level1"), gui)); }
                else { game.setState(null); }
        }
    }
}
