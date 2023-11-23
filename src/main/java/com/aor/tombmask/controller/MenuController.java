package com.aor.tombmask.controller;
import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.utils.MENU_OPTION;

import java.io.IOException;

public class MenuController extends AbstractController<Menu>{
    public MenuController(Menu menu){
        super(menu);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException {
        switch (action){
            case UP:
                getModel().upMenu();
                break;
            case DOWN:
                getModel().downMenu();
                break;
            case ENTER:
                if(getModel().isSelected(MENU_OPTION.PLAY)) { ; }
                else { game.setState(null); }
        }
    }
}
