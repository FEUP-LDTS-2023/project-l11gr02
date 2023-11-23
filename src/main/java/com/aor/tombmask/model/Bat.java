package com.aor.tombmask.model;

public class Bat extends Element{
    public Bat(int x, int y){
        super(x,y);
    }
    public Bat(Position position) {super(position.getX(), position.getY());}
}
