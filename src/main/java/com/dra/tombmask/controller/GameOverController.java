package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;

public class GameOverController extends AbstractController<GameOver>{

    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
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
        String path = "src/main/resources/levels/level"+ game.getCurrentArena();
        switch (getModel().getCurrentOption()){
            case PLAY -> {
                game.setState(new GameState(new Arena(60,30,path)));
            }
            case EXIT -> game.setState(new MenuState());
        }
    }
}