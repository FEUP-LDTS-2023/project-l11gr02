package com.dra.tombmask.model;

public class EndLevel extends Element{
    public EndLevel(int x, int y){
        super(x,y);
        setSymbol("e");
    }
    public EndLevel(Position position) {
        super(position.getX(),position.getY());
        setColor("#FFFF00");
        setSymbol("e");
    }
}
