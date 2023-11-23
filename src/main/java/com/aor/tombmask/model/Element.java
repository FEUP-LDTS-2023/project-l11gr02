package com.aor.tombmask.model;

public class Element {
    private Position position;

    public Element(int x, int y){
        this.position = new Position(x,y);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return getPosition().getX() == element.getPosition().getX() && getPosition().getY() == element.getPosition().getY();
    }
}
