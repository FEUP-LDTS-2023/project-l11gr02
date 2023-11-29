package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Hero extends Element{
    private DIRECTION direction;
    private double shieldedTime = 0;
    public Hero(Position position) {
        super(position.getX(),position.getY());
        this.direction = DIRECTION.IDLE;
    }

    public DIRECTION getDirection(){ return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }

    public double getShieldedTime() {
        return shieldedTime;
    }

    public Boolean isShielded(){
        return shieldedTime > 0;
    }

    public void setShieldedTime(double shieldedTime) {
        this.shieldedTime = shieldedTime;
    }
}
