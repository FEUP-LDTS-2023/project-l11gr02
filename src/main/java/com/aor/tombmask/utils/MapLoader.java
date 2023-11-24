package com.aor.tombmask.utils;

import com.aor.tombmask.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapLoader {
    private Hero hero;
    private final List<Bat> bats;
    private final List<Wall> walls;
    private final List<Spike> spikes;
    private final List<String> globalPositions;

    public MapLoader(String path) throws IOException {
        this.hero = new Hero(new Position(0, 0));
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.bats = new ArrayList<>();
        this.globalPositions = getGlobalPositions(path);
        createPositions(globalPositions);
    }

    public List<String> getGlobalPositions(String file) throws IOException {
        Path path = Paths.get(file);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
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
            }
        }
    }

    public Hero getHero() {return this.hero;}
    public List<Bat> getBats() {return this.bats;}
    public List<Wall> getWalls() {return this.walls;}
    public List<Spike> getSpikes() {return this.spikes;}
    public List<String> getGlobalPositions() {return this.globalPositions;}

}
