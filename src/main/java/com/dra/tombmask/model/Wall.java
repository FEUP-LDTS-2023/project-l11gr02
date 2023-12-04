package com.dra.tombmask.model;

public class Wall extends Element{
    public Wall(int x, int y){
        super(x,y);
        this.setColor("#993399");
        this.setSymbol(" ");
    }
    public Wall(Position position) {
        super(position.getX(),position.getY());
        this.setColor("#993399");
        this.setSymbol(" ");
    }
}
