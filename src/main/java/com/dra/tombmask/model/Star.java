package com.dra.tombmask.model;

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
        Mask.setCollected_stars(Mask.getCollected_stars()+1);
        arena.getCollectables().remove(this);
        arena.getGlobalElements().remove(this);
    }
    @Override
    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
