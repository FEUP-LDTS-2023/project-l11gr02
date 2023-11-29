package com.dra.tombmask.model;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Element implements Collectable{
    public Coin(int x, int y){
        super(x,y);
    }
    public Coin(Position position) {
        super(position.getX(),position.getY());
    }

    @Override
    public void collect(Position position, Arena arena, Hero hero) {
        hero.setCollected_coins(hero.getCollected_coins()+1);
        List<Coin> new_coins = new ArrayList<>();
        for(Coin coin : arena.getCoins()){
            if(!coin.getPosition().equals(position)){
                new_coins.add(coin);
            }
        }
        arena.setCoins(new_coins);
    }

    public String toString() {
        return "(" + getPosition().getX() + ", " + getPosition().getY() + ")";
    }
}
