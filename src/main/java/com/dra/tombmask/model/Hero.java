package com.dra.tombmask.model;

public class Hero extends Element{
    public Hero(int x, int y){
        super(x,y);
    }
    public Hero(Position position) {super(position.getX(),position.getY());}
}
