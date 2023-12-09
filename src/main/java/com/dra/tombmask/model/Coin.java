package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Collectable{
    public Coin(int x, int y){
        super(x,y);
        this.setSymbol("c");
    }
    public Coin(Position position){
        super(position.getX(),position.getY());
        this.setSymbol("c");
    }
    @Override
    public void collect(Arena arena) {
        Hero.setCollected_coins(Hero.getCollected_coins()+1);
        arena.getGlobalElements().remove(this);
    }

    @Override
    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
