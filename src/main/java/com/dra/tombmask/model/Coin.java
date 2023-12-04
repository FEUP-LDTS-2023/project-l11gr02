package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Collectable {
    public Coin(int x, int y){
        super(x,y);
    }
    public Coin(Position position){
        super(position.getX(),position.getY());
    }
    @Override
    public void collect(Arena arena) {
        arena.getHero().setCollected_coins(arena.getHero().getCollected_coins()+1);
        arena.getGlobalElements().remove(this);
    }
}
