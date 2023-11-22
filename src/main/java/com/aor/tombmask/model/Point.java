package com.aor.tombmask.model;

public class Point extends Element{
    private int collected_points;
    public Point(int x, int y){
        super(x,y);
        this.collected_points = 0;
    }

    public int getCollected_points() {
        return collected_points;
    }

    public void collect_point(){
        collected_points++;
    }
}
