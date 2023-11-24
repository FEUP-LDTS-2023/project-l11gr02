package com.dra.tombmask.model;

public class Spike extends Element{
    public Spike(int x, int y){
        super(x,y);
    }
    public Spike(Position position) {super(position.getX(),position.getY());}
}
