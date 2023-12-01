package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Point extends Element implements Collectable{
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
    public void collect(Position position, Arena arena, Hero hero) {
        Hero.setCollected_points(Hero.getCollected_points()+1);
        List<Point> new_points = new ArrayList<>();
        for(Point point : arena.getPoints()){
            if(!point.getPosition().equals(position)){
                new_points.add(point);
            }
        }
        arena.setPoints(new_points);
    }
}
