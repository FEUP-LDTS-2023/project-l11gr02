package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Point extends Collectable{
    public Point(int x, int y){
        super(x,y);
        this.setSymbol("p");
    }
    public Point(Position position) {
        super(position.getX(), position.getY());
        this.setSymbol("p");
    }
    @Override
    public void collect(Arena arena) {
        arena.getHero().setCollected_points(arena.getHero().getCollected_points()+1);
        arena.getGlobalElements().remove(this);
    }
}
