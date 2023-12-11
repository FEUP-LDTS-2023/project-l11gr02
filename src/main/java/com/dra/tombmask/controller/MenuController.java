package com.dra.tombmask.controller;
import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.*;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.MENU_OPTION;

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
                consumeOption(game);
                break;
        }
    }
    public void consumeOption(Game game) throws IOException {
        StateExecuter stateExecuter = new MenuStateHandler();
        switch (getModel().getCurrentOption()){
            case PLAY -> {
                stateExecuter = new GameStateHandler();
            }
            case STORE ->{
                stateExecuter = new StoreStateHandler();
            }
            case EXIT -> game.setState(null);
        }
        game.setState(stateExecuter.createStateHandler());
    }
}
