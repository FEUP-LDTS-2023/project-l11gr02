package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class DartTrap extends Element{
    private double standby = 0;
    private final DIRECTION direction;
    public DartTrap(int x, int y, DIRECTION direction){
        super(x, y);
        this.direction = direction;
    }
    public DartTrap(Position position, DIRECTION direction){
        super(position.getX(), position.getY());
        this.direction = direction;
    }

    public boolean inStandby() { return standby > 0; }

    public double getStandby() {
        return standby;
    }

    public void setStandby(double standby) {
        this.standby = standby;
    }

    public DIRECTION getDirection() {
        return direction;
    }
}
