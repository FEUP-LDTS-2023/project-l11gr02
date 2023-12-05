package com.dra.tombmask.model;

public abstract class Collectable extends Element{
    public Collectable(int x, int y) {
        super(x, y);
    }
    public abstract void collect(Arena arena);
}
