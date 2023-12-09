package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Bat;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;

public class BatController extends AbstractController<Arena>{
    public BatController(Arena arena){
        super(arena);
    }

    public void moveBat(Bat bat){
        if(bat.getTimeout() > 0){
            bat.setTimeout(Math.max(0, bat.getTimeout()-0.16));
            return;
        }
        int x = bat.getPosition().getX();
        int y = bat.getPosition().getY();
        switch (bat.getDirection()){
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x,y))){
                    bat.setDirection(DIRECTION.RIGHT);
                    break;
                }
                bat.setPosition(new Position(x,y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x,y))){
                    bat.setDirection(DIRECTION.LEFT);
                    break;
                }
                bat.setPosition(new Position(x,y));
                break;
            default:
                break;
        }
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        for(Bat bat : getModel().getBats()){
            moveBat(bat);
        }
    }
}
