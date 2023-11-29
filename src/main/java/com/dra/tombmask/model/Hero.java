package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Hero extends Element{
    private int collected_coins;
    private int collected_stars;
    private int collected_points;
    private DIRECTION direction;
    private double shieldedTime = 0;
    public Hero(Position position) {
        super(position.getX(),position.getY());
        this.direction = DIRECTION.IDLE;
        this.collected_coins = 0;
        this.collected_stars = 0;
        this.collected_points = 0;
        this.setColor("#FFFF00");
        this.setSymbol("h");
    }

    public DIRECTION getDirection(){ return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }

    public int getCollected_stars() {
        return collected_stars;
    }

    public int getCollected_points() {
        return collected_points;
    }

    public int getCollected_coins() {
        return collected_coins;
    }

    public void setCollected_coins(int collected_coins) {
        this.collected_coins = collected_coins;
    }

    public void setCollected_points(int collected_points) {
        this.collected_points = collected_points;
    }

    public void setCollected_stars(int collected_stars) {
        this.collected_stars = collected_stars;
    }

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
