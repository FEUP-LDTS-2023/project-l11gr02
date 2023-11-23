package com.aor.tombmask.model;

public class Wall extends Element{
    public Wall(int x, int y){
        super(x,y);
    }
    public Wall(Position position) {super(position.getX(),position.getY());}
}
