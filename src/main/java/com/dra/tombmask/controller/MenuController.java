package com.dra.tombmask.controller;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.Menu;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.StoreState;
import com.dra.tombmask.utils.ACTION;

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
        String path = "src/main/resources/levels/level"+ game.getCurrentTomb();
        switch (getModel().getCurrentOption()){
            case PLAY -> {
                game.setState(new GameState(new Tomb(60,30,path)));
            }
            case STORE ->{
                game.setState(new StoreState(new Store()));
            }
            case EXIT -> game.setState(null);
        }
    }
}
