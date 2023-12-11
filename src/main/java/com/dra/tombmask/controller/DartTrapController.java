package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.Dart;
import com.dra.tombmask.model.DartTrap;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;

public class DartTrapController extends AbstractController<Tomb>{
    public DartTrapController(Tomb tomb) {
        super(tomb);
    }

    private void shoot(DartTrap trap){
        if(trap.inStandby()) {
            trap.setStandby(trap.getStandby() - 0.08);
            return;
        }
        int x = trap.getPosition().getX();
        int y = trap.getPosition().getY();
        Dart dart;
        switch (trap.getDirection()){
            case LEFT:
                x--;
                dart = new Dart(x, y, DIRECTION.LEFT);
                getModel().getDarts().add(dart);
                getModel().getGlobalElements().add(dart);
                trap.setStandby(2);
                break;
            case UP:
                y--;
                dart = new Dart(x, y, DIRECTION.UP);
                getModel().getDarts().add(dart);
                getModel().getGlobalElements().add(dart);
                trap.setStandby(2);
                break;
            case RIGHT:
                x++;
                dart = new Dart(x, y, DIRECTION.RIGHT);
                getModel().getDarts().add(dart);
                getModel().getGlobalElements().add(dart);
                trap.setStandby(2);
                break;
            case DOWN:
                y++;
                dart = new Dart(x, y, DIRECTION.DOWN);
                getModel().getDarts().add(dart);
                getModel().getGlobalElements().add(dart);
                trap.setStandby(2);
                break;
        }
    }

    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        for(DartTrap trap : getModel().getDartTraps()){
            shoot(trap);
        }
    }
}
