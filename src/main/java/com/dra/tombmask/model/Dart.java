package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Dart extends Hazard{
    private DIRECTION direction;
    public Dart(int x, int y, DIRECTION direction){
        super(x, y);
        this.direction = direction;
    }

    public Dart(Position position, DIRECTION direction){
        super(position.getX(), position.getY());
        this.direction = direction;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
}
