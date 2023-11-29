package com.dra.tombmask.model;

public class Point extends Element{
    private int collected_points;
    public Point(int x, int y){
        super(x,y);
        this.collected_points = 0;
        this.setSymbol("p");
    }
    public Point(Position position){
        super(position.getX(), position.getY());
        this.collected_points = 0;
        this.setSymbol("p");
    }

    public int getCollected_points() {
        return collected_points;
    }

    public void collect_point(){
        collected_points++;
    }

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
