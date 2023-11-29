package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class HeroController extends AbstractController<Arena>{
    public HeroController(Arena arena){
        super(arena);
    }

    public Element moveHero(){
        Hero hero = getModel().getHero();
        int x = hero.getPosition().getX();
        int y = hero.getPosition().getY();
        switch (hero.getDirection()){
            case UP:
                y--;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case DOWN:
                y++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));

                hero.setPosition(new Position(x,y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case IDLE:
                break;
        }
        return null;
    }

    private Element checkCollision(Position position){
        if(getModel().getElementAtPosition(position) instanceof PowerUp){
            getModel().getPowerUpAtPosition(position).getStrategy().execute(getModel());
            return null;
        }
        return getModel().getElementAtPosition(position);
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        switch (action){
            case UP:
                if(getModel().getHero().getDirection() != DIRECTION.IDLE) break;
                getModel().getHero().setDirection(DIRECTION.UP);
                break;
            case DOWN:
                if(getModel().getHero().getDirection() != DIRECTION.IDLE) break;
                getModel().getHero().setDirection(DIRECTION.DOWN);
                break;
            case LEFT:
                if(getModel().getHero().getDirection() != DIRECTION.IDLE) break;
                getModel().getHero().setDirection(DIRECTION.LEFT);
                break;
            case RIGHT:
                if(getModel().getHero().getDirection() != DIRECTION.IDLE) break;
                getModel().getHero().setDirection(DIRECTION.RIGHT);
                break;
        }
        if(moveHero() instanceof EndLevel) {
            game.setCurrentArena(game.currentArena + 1);
            try {
                String path = "./src/main/resources/levels/level"+game.currentArena;
                game.setState(new GameState(new Arena(60, 30,path)));
            }catch (IOException e){
                game.setState(null);
            }
        }
        else if(moveHero() instanceof Bat || moveHero() instanceof Spike){
            game.setState(null);
        }
    }
}
