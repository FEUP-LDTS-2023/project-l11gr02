package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Position;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class HeroController extends AbstractController<Arena>{
    public HeroController(Arena arena){
        super(arena);
    }
    public void moveUp(Game game, GUI gui, int x, int y) throws IOException, InterruptedException {
        while (true){
            y--;
            if(!getModel().isEmpty(new Position(x,y))) break;
            if(getModel().isEmpty(new Position(x,y))){
                getModel().getHero().setPosition(new Position(x,y));
                game.gameView.draw(gui);
                Thread.sleep(5);
                continue;
            }
            break;
        }
    }

    public void moveDown(Game game, GUI gui, int x, int y) throws IOException, InterruptedException {
        while (true){
            y++;
            if(!getModel().isEmpty(new Position(x,y))) break;
            if(getModel().isEmpty(new Position(x,y))){
                getModel().getHero().setPosition(new Position(x,y));
                game.gameView.draw(gui);
                Thread.sleep(5);
                continue;
            }
            break;
        }
    }

    public void moveLeft(Game game, GUI gui, int x, int y) throws IOException, InterruptedException {
        while (true){
            x--;
            if(!getModel().isEmpty(new Position(x,y))) break;
            if(getModel().isEmpty(new Position(x,y))){
                getModel().getHero().setPosition(new Position(x,y));
                game.gameView.draw(gui);
                Thread.sleep(5);
                continue;
            }
            break;
        }
    }

    public void moveRight(Game game, GUI gui, int x, int y) throws IOException, InterruptedException {
        while (true){
            x++;
            if(!getModel().isEmpty(new Position(x,y))) break;
            if(getModel().isEmpty(new Position(x,y))){
                getModel().getHero().setPosition(new Position(x,y));
                game.gameView.draw(gui);
                Thread.sleep(5);
                continue;
            }
            break;
        }
    }
    @Override
    public void executeState(Game game, ACTION action, GUI gui) throws IOException, InterruptedException {
        int x = getModel().getHero().getPosition().getX();
        int y = getModel().getHero().getPosition().getY();
        switch (action){
            case UP:
                moveUp(game, gui, x, y);
                break;
            case DOWN:
                moveDown(game, gui, x, y);
                break;
            case LEFT:
                moveLeft(game, gui, x, y);
                break;
            case RIGHT:
                moveRight(game, gui, x, y);
                break;
        }
    }
}
