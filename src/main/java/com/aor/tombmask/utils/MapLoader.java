package com.aor.tombmask.utils;

import com.aor.tombmask.model.Position;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {
    private Position heroPosition;
    private final List<Position> batPositions;
    private final List<Position> wallPositions;
    private final List<Position> spikePositions;
    private final List<String> globalPositions;

    public MapLoader(String path) throws IOException {
        this.heroPosition = new Position(0,0);
        this.wallPositions = new ArrayList<>();
        this.spikePositions = new ArrayList<>();
        this.batPositions = new ArrayList<>();
        this.globalPositions = getGlobalPositions(path);
        createPositions(globalPositions);
    }

    public List<String> getGlobalPositions(String file) throws IOException {
        Path path = Paths.get(file);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public void createPositions(List<String> globalPositions) {
        for(int j = 0; j < globalPositions.size(); j++) {
            String string = globalPositions.get(j);
            for(int i = 0 ; i < string.length(); i++) {
                Position currentPosition = new Position(i,j);
                if(string.charAt(i) == 'W') wallPositions.add(currentPosition);
                if(string.charAt(i) == 'B') batPositions.add(currentPosition);
                if(string.charAt(i) == 'S') spikePositions.add(currentPosition);
                if(string.charAt(i) == 'H') heroPosition = currentPosition;
            }
        }
    }

    public Position getHeroPosition() {return this.heroPosition;}
    public List<Position> getBatPositions() {return this.batPositions;}
    public List<Position> getWallPositions() {return this.wallPositions;}
    public List<Position> getSpikePositions() {return this.spikePositions;}
    public List<String> getGlobalPositions() {return this.globalPositions;}

}
