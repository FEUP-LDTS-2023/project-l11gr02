package com.dra.tombmask.model;

import com.dra.tombmask.utils.MapLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;
    private EndLevel endLevel;
    private List<Bat> bats;
    private List<Wall> walls;
    private List<Spike> spikes;
    private List<Coin> coins;
    private List<Star> stars;
    private List<Point> points;
    private List<PowerUp> powerUps;
    private List<Element> globalElements;

    public Arena(int width, int height, String path) throws IOException {
        MapLoader loader = new MapLoader(path);
        this.width = width;
        this.height = height;
        this.bats = loader.getBats();
        this.hero = loader.getHero();
        this.endLevel = loader.getEndLevel();
        this.walls = loader.getWalls();
        this.spikes = loader.getSpikes();
        this.powerUps = loader.getPowerUps();
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
        this.powerUps = new ArrayList<>();
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

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
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

    public EndLevel getEnd() {
        return endLevel;
    }

    public void setEnd(EndLevel end) {
        this.endLevel = end;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Element getElementAtPosition(Position position) {
        for (Element e : globalElements) {
            if (e.getPosition().equals(position)) {
                return e;
            }
        }
        return null;
    }

    public PowerUp getPowerUpAtPosition(Position position) {
        for(PowerUp p : powerUps){
            if(p.getPosition().equals(position)){
                return p;
            }
        }
        return null;
    }

    public boolean isEnd(Position position){
        return position.equals(endLevel.getPosition());
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public <T>void remove_Collectable(T obj){
        if(obj instanceof Coin){
            Iterator<Coin> iterator = coins.iterator();
            while (iterator.hasNext()) {
                Coin coin = iterator.next();
                if (coin.getPosition().equals(((Coin) obj).getPosition())) {
                    iterator.remove();
                }
            }
        }
        else if(obj instanceof Star){
            Iterator<Star> iterator = stars.iterator();
            while (iterator.hasNext()) {
                Star star = iterator.next();
                if (star.getPosition().equals(((Star) obj).getPosition())) {
                    iterator.remove();
                }
            }
        }
        else if(obj instanceof Point){
            Iterator<Point> iterator = points.iterator();
            while (iterator.hasNext()) {
                Point point = iterator.next();
                if (point.getPosition().equals(((Point) obj).getPosition())) {
                    iterator.remove();
                }
            }
        }
    }
}
