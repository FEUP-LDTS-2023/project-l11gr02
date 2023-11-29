package com.dra.tombmask.utils;

import com.dra.tombmask.model.*;
import com.dra.tombmask.powerups.FreezeStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapLoader {
    private Hero hero;
    private EndLevel endLevel;
    private final List<Bat> bats;
    private final List<Wall> walls;
    private final List<Spike> spikes;
    private final List<String> globalPositions;
    private final List<PowerUp> powerUps;
    private final List<Element> globalElements;

    public MapLoader(String path) throws IOException {
        this.hero = new Hero(new Position(0, 0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.bats = new ArrayList<>();
        this.globalPositions = getGlobalPositions(path);
        this.powerUps = new ArrayList<>();
        this.globalElements = new ArrayList<>();
        createPositions(globalPositions);
    }

    public List<String> getGlobalPositions(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(Paths.get(file))));
        String line;
        List<String> result = new ArrayList<String>();
        while((line = bufferedReader.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    public void createPositions(List<String> globalPositions) {
        Random random = new Random();
        for(int j = 0; j < globalPositions.size(); j++) {
            String string = globalPositions.get(j);
            for(int i = 0 ; i < string.length(); i++) {
                Position currentPosition = new Position(i,j);
                switch (string.charAt(i)){
                    case 'W':
                        Wall wall = new Wall(currentPosition);
                        walls.add(wall);
                        globalElements.add(wall);
                        break;
                    case 'B':
                        Bat bat = new Bat(currentPosition, random.nextBoolean());
                        bats.add(bat);
                        globalElements.add(bat);
                        break;
                    case 'S':
                        Spike spike = new Spike(currentPosition);
                        spikes.add(spike);
                        globalElements.add(spike);
                        break;
                    case 'H':
                        Hero hero = new Hero(currentPosition);
                        this.hero = hero;
                        globalElements.add(hero);
                        break;
                    case 'E':
                        EndLevel endLevel = new EndLevel(currentPosition);
                        this.endLevel = endLevel;
                        globalElements.add(endLevel);
                    case 'F':
                        PowerUp powerUp = new PowerUp(currentPosition, new FreezeStrategy());
                        powerUps.add(powerUp);
                        globalElements.add(powerUp);
                        break;
                }
            }
        }
    }

    public Hero getHero() {return this.hero;}
    public EndLevel getEndLevel() {return this.endLevel;}
    public List<Bat> getBats() {return this.bats;}
    public List<Wall> getWalls() {return this.walls;}
    public List<Spike> getSpikes() {return this.spikes;}
    public List<String> getGlobalPositions() {return this.globalPositions; }
    public List<Element> getGlobalElements() { return this.globalElements; }
    public List<PowerUp> getPowerUps() { return this.powerUps; }

}
