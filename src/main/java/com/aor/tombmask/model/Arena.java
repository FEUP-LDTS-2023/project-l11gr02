package com.aor.tombmask.model;

import com.aor.tombmask.utils.MapLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;
    private List<Bat> bats;
    private List<Wall> walls;
    private List<Spike> spikes;
    private EndLevel end;
    private List<Coin> coins;
    private List<Star> stars;
    private List<Point> points;

    public Arena(int width, int height, String path) throws IOException {
        MapLoader loader = new MapLoader(path);
        this.width = width;
        this.height = height;
        this.bats = loader.getBats();
        this.hero = loader.getHero();
        this.walls = loader.getWalls();
        this.spikes = loader.getSpikes();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

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

    public EndLevel getEnd() {
        return end;
    }

    public void setEnd(EndLevel end) {
        this.end = end;
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

    public boolean isBat(Position position) {
        for (Bat bat : bats)
            if (bat.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isSpike(Position position) {
        for (Spike spike : spikes)
            if (spike.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isCoin(Position position){
        for(Coin coin : coins){
            if(coin.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public boolean isStar(Position position){
        for(Star star : stars){
            if(star.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public boolean isPoint(Position position){
        for(Point point : points){
            if(point.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public <T>void remove_Collectable(T obj){
        if(obj instanceof Coin){
            for(Coin coin : coins){
                if(coin.getPosition().equals(((Coin) obj).getPosition())){
                    coins.remove(coin);
                }
            }
        }
        else if(obj instanceof Star){
            for(Star star : stars){
                if(star.getPosition().equals(((Star) obj).getPosition())){
                    stars.remove(star);
                }
            }
        }
        else if(obj instanceof Point){
            for(Point point : points){
                if(point.getPosition().equals(((Point) obj).getPosition())){
                    points.remove(point);
                }
            }
        }
    }
}
