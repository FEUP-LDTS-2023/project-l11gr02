package com.dra.tombmask.model;

public class Coin extends Collectable{
    public Coin(int x, int y){
        super(x,y);
        this.setSymbol("c");
    }
    public Coin(Position position){
        super(position.getX(),position.getY());
        this.setSymbol("c");
    }
    @Override
    public void collect(Arena arena) {
        Mask.setCollected_coins(Mask.getCollected_coins()+1);
        arena.getCollectables().remove(this);
        arena.getGlobalElements().remove(this);
    }

    @Override
    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
