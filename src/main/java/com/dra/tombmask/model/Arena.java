package com.dra.tombmask.model;

import com.dra.tombmask.utils.MapLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Mask mask;
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
        Mask.setCollectedStars(0);
        Mask.setCollectedPoints(0);
        this.width = width;
        this.height = height;
        path = path == null ? "./src/main/resources/levels/level1" : path;
        MapLoader loader = new MapLoader(path);
        this.path = path;
        this.bats = loader.getBats();
        this.mask = loader.getMask();
        this.endLevel = loader.getEndLevel();
        this.walls = loader.getWalls();
        this.dartTraps = loader.getDartTraps();
        this.darts = new ArrayList<>();
        this.spikes = loader.getSpikes();
        setAvailableStars(loader.getAvailableStars());
        this.collectables = loader.getCollectables();
        this.powerUps = loader.getPowerUps();
        this.globalElements = loader.getGlobalElements();
    }
    public Arena(int width,int height) throws IOException {
        Mask.setCollectedStars(0);
        Mask.setCollectedPoints(0);
        this.width = width;
        this.height = height;
        this.bats = new ArrayList<>();
        this.mask = new Mask(new Position(0,0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.dartTraps = new ArrayList<>();
        this.darts = new ArrayList<>();
        setAvailableStars(0);
        this.globalElements = new ArrayList<Element>();
    }

    public int getAvailableStars() {return availableStars;}

    static void setAvailableStars(int availableStars){
        Arena.availableStars = availableStars;
    }

    public String getPath() {
        return path == null ? "" : path;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EndLevel getEndLevel() {return endLevel;}
    public void setEndLevel(EndLevel endLevel) {this.endLevel = endLevel;}

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
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

    public List<Dart> getDarts() { return darts; }

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
