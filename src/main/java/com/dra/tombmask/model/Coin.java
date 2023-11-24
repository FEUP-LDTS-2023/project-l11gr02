package com.dra.tombmask.model;

public class Coin extends Element{
    private Arena arena;
    private int collected_coins;
    public Coin(int x, int y){
        super(x,y);
        this.collected_coins = 0;
    }
    public Coin(Position position) {
        super(position.getX(),position.getY());
        this.collected_coins = 0;
    }

    public void collect_coin(){
        collected_coins++;
    }

    public int getCollected_coins() {
        return collected_coins;
    }

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
