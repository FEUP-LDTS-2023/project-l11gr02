package com.aor.tombmask.model;

public class EndLevel extends Element{
    public EndLevel(int x, int y){
        super(x,y);
    }
    public EndLevel(Position position) {super(position.getX(),position.getY());}
}
