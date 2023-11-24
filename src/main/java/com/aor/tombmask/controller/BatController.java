package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Bat;
import com.aor.tombmask.model.Position;
import com.aor.tombmask.utils.ACTION;
import com.aor.tombmask.utils.DIRECTION;

import java.io.IOException;

public class BatController extends AbstractController<Arena>{
    public BatController(Arena arena){
        super(arena);
    }

    public void moveBat(Bat bat){
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
        }
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        for(Bat bat : getModel().getBats()){
            moveBat(bat);
        }
    }
}
