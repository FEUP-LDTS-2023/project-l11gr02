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
        arena.getHero().setCollected_stars(arena.getHero().getCollected_stars()+1);
        arena.getGlobalElements().remove(this);
    }
}
