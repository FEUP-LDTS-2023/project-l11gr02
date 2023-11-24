package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Hero;
import com.aor.tombmask.model.Position;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.utils.DIRECTION;

import java.io.IOException;

public class HeroController extends AbstractController<Arena>{
    public HeroController(Arena arena){
        super(arena);
    }

    public void moveHero(){
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
                hero.setPosition(new Position(x,y));
                break;
            case DOWN:
                y++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                hero.setPosition(new Position(x,y));
                break;
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                hero.setPosition(new Position(x,y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                hero.setPosition(new Position(x,y));
                break;
            case IDLE:
                break;
        }
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
        moveHero();
    }
}
