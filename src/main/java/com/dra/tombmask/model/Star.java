package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Star extends Collectable{
    public Star(int x, int y){
        super(x,y);
        this.setSymbol("S");
    }
    public Star(Position position){
        super(position.getX(),position.getY());
        this.setSymbol("S");
    }
    @Override
    public void collect(Arena arena) {
        Hero.setCollected_stars(Hero.getCollected_stars()+1);
        arena.getGlobalElements().remove(this);
    }

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
