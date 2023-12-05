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

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }

    @Override
    public void collect(Arena arena) {
        Hero.setCollected_points(Hero.getCollected_points()+1);
        List<Collectable> new_collectables = new ArrayList<>();
        for(Collectable collectable : arena.getCollectables()){
            if(!collectable.getPosition().equals(this.getPosition())){
                new_collectables.add(collectable);
            }
        }
        arena.setCollectables(new_collectables);
    }
}
