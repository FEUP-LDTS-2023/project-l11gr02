package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.state.*;
import com.dra.tombmask.utils.ACTION;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

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
            default:
                break;
        }
    }

    public void consumeOption(Game game) throws IOException {
        StateExecuter stateExecuter = new GameStateHandler();
        switch (getModel().getCurrentOption()){
            case PLAY -> {
                stateExecuter = new GameStateHandler();
            }
            case EXIT -> stateExecuter = new MenuStateHandler();
            default -> {}
        }
        game.setState(stateExecuter.createStateHandler());
    }
}
