package com.dra.tombmask.model;

import java.awt.*;

public class Element {
    private Position position;
    private String color;
    private String symbol;

    public Element(int x, int y){
        this.position = new Position(x,y);
        this.color = "#FFFF00";
    }
    public Position getPosition() {
        return position;
    }
    public String getColor(){return color;}
    public String getSymbol(){return symbol;}

    public void setPosition(Position position) {
        this.position = position;
    }
    public void setColor(String color) {this.color = color;}
    public void setSymbol(String symbol){this.symbol= symbol;}
    @Override
    @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return getPosition().getX() == element.getPosition().getX() && getPosition().getY() == element.getPosition().getY();
    }
}
