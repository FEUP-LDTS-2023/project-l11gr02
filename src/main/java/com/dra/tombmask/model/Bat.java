package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Bat extends Element{
    private DIRECTION direction;
    public Bat(int x, int y, Boolean bool){
        super(x,y);
        direction = !bool ? DIRECTION.LEFT : DIRECTION.RIGHT;
    }
    public Bat(Position position, Boolean bool) {
        super(position.getX(), position.getY());
        direction = !bool ? DIRECTION.LEFT : DIRECTION.RIGHT;
    }

    public DIRECTION getDirection() { return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }
}
