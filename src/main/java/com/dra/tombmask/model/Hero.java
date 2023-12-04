package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

public class Hero extends Element{
    public static int collected_coins = 0;
    public static int collected_stars = 0;
    public static int collected_points = 0;
    private DIRECTION direction;
    private double shieldedTime = 0;
    public Hero(Position position) {
        super(position.getX(),position.getY());
        this.direction = DIRECTION.IDLE;
        this.setColor("#FFFF00");
        this.setSymbol("h");
    }

    public DIRECTION getDirection(){ return direction; }
    public void setDirection(DIRECTION direction) { this.direction = direction; }

    public static int getCollected_stars() {
        return collected_stars;
    }

    public static int getCollected_points() {
        return collected_points;
    }

    public static int getCollected_coins() {
        return collected_coins;
    }

    public static void setCollected_coins(int collected_coins) {
        Hero.collected_coins = collected_coins;
    }

    public static void setCollected_points(int collected_points) {
        Hero.collected_points = collected_points;
    }

    public static void setCollected_stars(int collected_stars) {
        Hero.collected_stars = collected_stars;
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
