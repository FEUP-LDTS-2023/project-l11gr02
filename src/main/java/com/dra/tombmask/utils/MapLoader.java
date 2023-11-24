package com.dra.tombmask.utils;

import com.dra.tombmask.model.*;

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

    public MapLoader(String path) throws IOException {
        this.hero = new Hero(new Position(0, 0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.bats = new ArrayList<>();
        this.globalPositions = getGlobalPositions(path);
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
                if(string.charAt(i) == 'W') walls.add(new Wall(currentPosition));
                if(string.charAt(i) == 'B') bats.add(new Bat(currentPosition, random.nextBoolean()));
                if(string.charAt(i) == 'S') spikes.add(new Spike(currentPosition));
                if(string.charAt(i) == 'H') hero = new Hero(currentPosition);
                if(string.charAt(i) == 'E') endLevel = new EndLevel(currentPosition);
            }
        }
    }

    public Hero getHero() {return this.hero;}
    public EndLevel getEndLevel() {return this.endLevel;}
    public List<Bat> getBats() {return this.bats;}
    public List<Wall> getWalls() {return this.walls;}
    public List<Spike> getSpikes() {return this.spikes;}
    public List<String> getGlobalPositions() {return this.globalPositions;}

}
