package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Dart;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.utils.ACTION;

import java.io.IOException;

public class DartController extends AbstractController<Arena>{
    public DartController(Arena arena) { super(arena); }

    public void moveDart(Dart dart){
        int x = dart.getPosition().getX();
        int y = dart.getPosition().getY();
        switch (dart.getDirection()){
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x, y))){
                    getModel().getDarts().remove(dart);
                    getModel().getGlobalElements().remove(dart);
                    return;
                }
                dart.setPosition(new Position(x, y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x, y))){
                    getModel().getDarts().remove(dart);
                    getModel().getGlobalElements().remove(dart);
                    return;
                }
                dart.setPosition(new Position(x, y));
                break;
            case UP:
                y--;
                if(!getModel().isEmpty(new Position(x, y))){
                    getModel().getDarts().remove(dart);
                    getModel().getGlobalElements().remove(dart);
                    return;
                }
                dart.setPosition(new Position(x, y));
                break;
            case DOWN:
                y++;
                if(!getModel().isEmpty(new Position(x, y))){
                    getModel().getDarts().remove(dart);
                    getModel().getGlobalElements().remove(dart);
                    return;
                }
                dart.setPosition(new Position(x, y));
                break;
            default:
        }
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        for(int i = 0; i < getModel().getDarts().size(); i++){
            moveDart(getModel().getDarts().get(i));
        }
    }
}
