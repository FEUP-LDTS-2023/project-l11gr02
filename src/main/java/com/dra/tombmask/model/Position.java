package com.dra.tombmask.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
