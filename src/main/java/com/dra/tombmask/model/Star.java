package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Star extends Element implements Collectable{
    public Star(int x, int y){
        super(x,y);
        this.setSymbol("S");
    }
    public Star(Position position){
        super(position.getX(),position.getY());
        this.setSymbol("S");
    }

    @Override
    public void collect(Position position, Arena arena, Hero hero) {
        Hero.setCollected_stars(Hero.getCollected_stars()+1);
        List<Star> new_stars = new ArrayList<>();
        for(Star star : arena.getStars()){
            if(!star.getPosition().equals(position)){
                new_stars.add(star);
            }
        }
        arena.setStars(new_stars);
    }

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
