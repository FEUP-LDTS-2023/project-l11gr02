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
    private List<Collectable> collectables;
    private List<PowerUp> powerUps;
    private List<Element> globalElements;
    public static int availableStars;
    private String path;

    public Arena(int width, int height, String path) throws IOException {
        Hero.collected_stars = 0;
        Hero.collected_points = 0;
        MapLoader loader = new MapLoader(path);
        this.path = path;
        this.width = width;
        this.height = height;
        this.bats = loader.getBats();
        this.hero = loader.getHero();
        this.endLevel = loader.getEndLevel();
        this.walls = loader.getWalls();
        this.dartTraps = loader.getDartTraps();
        this.darts = new ArrayList<>();
        this.spikes = loader.getSpikes();
        this.availableStars = loader.getAvailableStars();
        this.collectables = loader.getCollectables();
        this.powerUps = loader.getPowerUps();
        this.globalElements = loader.getGlobalElements();
    }
    public Arena(int width,int height) throws IOException {
        Hero.collected_stars = 0;
        Hero.collected_points = 0;
        this.width = width;
        this.height = height;
        this.bats = new ArrayList<>();
        this.hero = new Hero(new Position(0,0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.dartTraps = new ArrayList<>();
        this.darts = new ArrayList<>();
        this.availableStars = 0;
        this.globalElements = new ArrayList<Element>();
    }

    public int getAvailableStars() {return this.availableStars;}

    public String getPath() {
        return path;
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
    public void setSpikes(List<Spike> spikes) {
        this.spikes = spikes;
    }

    public List<DartTrap> getDartTraps() { return dartTraps; }

    public void setDartTraps(List<DartTrap> dartTraps) { this.dartTraps = dartTraps; }

    public List<Dart> getDarts() { return darts; }

    public void setDarts(List<Dart> darts) { this.darts = darts; }

    public void setCollectables(List<Collectable> collectables) {
        this.collectables = collectables;
    }

    public List<Collectable> getCollectables() {
        return collectables;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
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
