package com.dra.tombmask.model;

import com.dra.tombmask.utils.MapLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Hero hero;
    private EndLevel endLevel;
    private List<Bat> bats;
    private List<Wall> walls;
    private List<Spike> spikes;
    private List<DartTrap> dartTraps;
    private List<Dart> darts;
    private List<Element> globalElements;

    public Arena(int width, int height, String path) throws IOException {
        MapLoader loader = new MapLoader(path);
        this.width = width;
        this.height = height;
        this.bats = loader.getBats();
        this.hero = loader.getHero();
        this.endLevel = loader.getEndLevel();
        this.walls = loader.getWalls();
        this.dartTraps = loader.getDartTraps();
        this.darts = new ArrayList<>();
        this.spikes = loader.getSpikes();
        this.globalElements = loader.getGlobalElements();
    }
    public Arena(int width,int height) {
        this.width = width;
        this.height = height;
        this.bats = new ArrayList<>();
        this.hero = new Hero(new Position(0,0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.dartTraps = new ArrayList<>();
        this.darts = new ArrayList<>();
        this.globalElements = new ArrayList<Element>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EndLevel getEndLevel() {return endLevel;}
    public void setEndLevel(EndLevel endLevel) {this.endLevel = endLevel;}

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Bat> getBats() {
        return bats;
    }

    public void setBats(List<Bat> bats) {
        this.bats = bats;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Spike> getSpikes() {
        return spikes;
    }

    public List<DartTrap> getDartTraps() { return dartTraps; }

    public void setDartTraps(List<DartTrap> dartTraps) { this.dartTraps = dartTraps; }

    public List<Dart> getDarts() { return darts; }

    public void setDarts(List<Dart> darts) { this.darts = darts; }

    public void setSpikes(List<Spike> spikes) {
        this.spikes = spikes;
    }

    public EndLevel getEnd() {
        return endLevel;
    }

    public void setEnd(EndLevel end) {
        this.endLevel = end;
    }

    public Element getElementAtPosition(Position position) {
        for (Element e : globalElements) {
            if (e.getPosition().equals(position)) {
                return e;
            }
        }
        return null;
    }

    public boolean isEnd(Position position){
        return position.equals(endLevel.getPosition());
    }

    public boolean isEmpty(Position position) {
        for (Element element : globalElements)
            if (element.getPosition().equals(position) && (element instanceof Wall || element instanceof DartTrap))
                return false;
        return true;
    }

    public List<Element> getGlobalElements(){ return globalElements; }
    public void setGlobalElements(List<Element> globalElements){ this.globalElements = globalElements; }
}
