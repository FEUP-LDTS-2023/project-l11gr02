package com.dra.tombmask.model;

public class Star extends Element{
    private int collected_stars;
    public Star(int x, int y){
        super(x,y);
        this.collected_stars = 0;
        this.setSymbol("S");
    }
    public Star(Position position){
        super(position.getX(),position.getY());
        this.collected_stars = 0;
        this.setSymbol("S");
    }

    public int getCollected_stars() {
        return collected_stars;
    }

    public void collect_star(){
        collected_stars++;
    }

}
