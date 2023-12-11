package com.dra.tombmask.model;

import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;

public class Mask extends Element{
    public static int collected_coins = 0;
    public static int collected_stars = 0;
    public static int collected_points = 0;
    private DIRECTION direction;
    private double shieldedTime = 0;
    private double magnetTime = 0;
    public Mask(Position position) throws IOException {
        super(position.getX(),position.getY());
        this.direction = DIRECTION.IDLE;
        Store store = new Store();
        Mask.collected_coins = store.getCurrentCoins();
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
        Mask.collected_coins = collected_coins;
    }

    public static void setCollected_points(int collected_points) {
        Mask.collected_points = collected_points;
    }

    public static void setCollected_stars(int collected_stars) {
        Mask.collected_stars = collected_stars;
    }

    public double getShieldedTime() {
        return shieldedTime;
    }

    public Boolean isShielded(){
        return shieldedTime > 0;
    }
    public Boolean isMagnet(){
        return magnetTime > 0;
    }

    public void setShieldedTime(double shieldedTime) {
        this.shieldedTime = shieldedTime;
    }

    public double getMagnetTime() {
        return magnetTime;
    }

    public void setMagnetTime(double magnetTime) {
        this.magnetTime = magnetTime;
    }
}
