package com.dra.tombmask.controller;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Hero;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;
import java.util.Objects;

public class HeroController extends AbstractController<Arena>{
    public HeroController(Arena arena){
        super(arena);
    }

    public String moveHero(){
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
                if(!collisionCheck(new Position(x, y)).isEmpty()) return collisionCheck(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case DOWN:
                y++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(!collisionCheck(new Position(x, y)).isEmpty()) return collisionCheck(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(!collisionCheck(new Position(x, y)).isEmpty()) return collisionCheck(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x,y))){
                    hero.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(!collisionCheck(new Position(x, y)).isEmpty()) return collisionCheck(new Position(x,y));
                hero.setPosition(new Position(x,y));
                break;
            case IDLE:
                break;
        }
        return "";
    }

    private String collisionCheck(Position position) {
        if(getModel().isEnd(position)) return "end";
        if(getModel().isBat(position)) return "bat";
        if(getModel().isSpike(position)) return "spike";
        return "";
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
        if(Objects.equals(moveHero(), "bat") || Objects.equals(moveHero(),"spike")) game.setState(null);
        else if(Objects.equals(moveHero(), "end")) {
            game.setCurrentArena(game.currentArena + 1);
            try {
                game.setState(new GameState(new Arena(60, 30, String.format("docs/level%s", game.currentArena))));
            }catch (IOException e){
                game.setState(null);
            }
        }
    }
}
