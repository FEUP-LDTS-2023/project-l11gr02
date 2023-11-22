package com.aor.tombmask.model;

public class Coin extends Element{
    private int collected_coins;
    public Coin(int x, int y){
        super(x,y);
        this.collected_coins = 0;
    }

    public void collect_coin(){
        collected_coins++;
    }

    public int getCollected_coins() {
        return collected_coins;
    }
}
