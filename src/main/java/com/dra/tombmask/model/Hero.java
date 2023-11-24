package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Hero extends Element{
    private DIRECTION direction;
    public Hero(Position position) {
        super(position.getX(),position.getY());
        this.direction = DIRECTION.IDLE;
    }

    public DIRECTION getDirection(){ return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }
}
