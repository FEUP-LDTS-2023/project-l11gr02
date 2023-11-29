package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

import java.util.ArrayList;
import java.util.List;

public class Bat extends Element{
    private Arena arena;
    private DIRECTION direction;
    public Bat(int x, int y, Boolean currentDirection){
        super(x,y);
        this.direction = !currentDirection ? DIRECTION.LEFT : DIRECTION.RIGHT;
        this.setColor("#636261");
        this.setSymbol("b");
    }
    public Bat(Position position, Boolean currentDirection) {
        super(position.getX(), position.getY());
        this.setColor("#636261");
        this.setSymbol("b");
        this.direction = !currentDirection ? DIRECTION.LEFT : DIRECTION.RIGHT;
    }

    public DIRECTION getDirection() { return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }
}
