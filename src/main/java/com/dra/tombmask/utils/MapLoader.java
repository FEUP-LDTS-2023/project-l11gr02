package com.dra.tombmask.utils;

import com.dra.tombmask.model.*;
import com.dra.tombmask.powerups.CoinMagnetStrategy;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.ShieldStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapLoader {
    private Mask mask;
    private EndLevel endLevel;
    private final List<Bat> bats;
    private final List<Wall> walls;
    private final List<Spike> spikes;
    private final List<DartTrap> dartTraps;
    private final List<Collectable> collectables;
    private final List<PowerUp> powerUps;
    private final List<String> globalPositions;
    private final List<Element> globalElements;

    private int availableStars;

    public MapLoader(String path) throws IOException {
        this.mask = new Mask(new Position(0, 0));
        this.endLevel = new EndLevel(0,0);
        this.walls = new ArrayList<>();
        this.spikes = new ArrayList<>();
        this.bats = new ArrayList<>();
        this.dartTraps = new ArrayList<>();
        this.collectables = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.globalPositions = getGlobalPositions(path);
        this.globalElements = new ArrayList<>();
        this.availableStars = 0;
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

    public void createPositions(List<String> globalPositions) throws IOException {
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
                        this.mask = new Mask(currentPosition);
                        break;
                    case 'E':
                        EndLevel endLevel = new EndLevel(currentPosition);
                        this.endLevel = endLevel;
                        globalElements.add(endLevel);
                        break;
                    case 'F':
                        PowerUp freeze = new PowerUp(currentPosition, new FreezeStrategy());
                        powerUps.add(freeze);
                        globalElements.add(freeze);
                        break;
                    case 'G':
                        PowerUp shield = new PowerUp(currentPosition, new ShieldStrategy());
                        powerUps.add(shield);
                        globalElements.add(shield);
                        break;
                    case 'o':
                        Coin coin = new Coin(currentPosition);
                        collectables.add(coin);
                        globalElements.add(coin);
                        break;
                    case '.':
                        Point point = new Point(currentPosition);
                        collectables.add(point);
                        globalElements.add(point);
                        break;
                    case '*':
                        Star star = new Star(currentPosition);
                        availableStars++;
                        collectables.add(star);
                        globalElements.add(star);
                        break;
                    case 'M':
                        PowerUp magnet = new PowerUp(currentPosition, new CoinMagnetStrategy());
                        powerUps.add(magnet);
                        globalElements.add(magnet);
                        break;
                    case 'R':
                        DartTrap trapRight = new DartTrap(currentPosition, DIRECTION.RIGHT);
                        dartTraps.add(trapRight);
                        globalElements.add(trapRight);
                        break;
                    case 'L':
                        DartTrap trapLeft = new DartTrap(currentPosition, DIRECTION.LEFT);
                        dartTraps.add(trapLeft);
                        globalElements.add(trapLeft);
                        break;
                    case 'U':
                        DartTrap trapUp = new DartTrap(currentPosition, DIRECTION.UP);
                        dartTraps.add(trapUp);
                        globalElements.add(trapUp);
                        break;
                    case 'D':
                        DartTrap trapDown = new DartTrap(currentPosition, DIRECTION.DOWN);
                        dartTraps.add(trapDown);
                        globalElements.add(trapDown);
                        break;
                    case '1':
                        Trampoline trampolineTopLeft = new Trampoline(currentPosition, CORNER.TOPLEFT);
                        globalElements.add(trampolineTopLeft);
                        break;
                    case '2':
                        Trampoline trampolineTopRight = new Trampoline(currentPosition, CORNER.TOPRIGHT);
                        globalElements.add(trampolineTopRight);
                        break;
                    case '3':
                        Trampoline trampolineBotLeft = new Trampoline(currentPosition, CORNER.BOTLEFT);
                        globalElements.add(trampolineBotLeft);
                        break;
                    case '4':
                        Trampoline trampolineBotRight = new Trampoline(currentPosition, CORNER.BOTRIGHT);
                        globalElements.add(trampolineBotRight);
                        break;
                }
            }
        }
    }

    public Mask getMask() {return this.mask;}
    public EndLevel getEndLevel() {return this.endLevel;}
    public List<Bat> getBats() {return this.bats;}
    public List<Wall> getWalls() {return this.walls;}
    public List<Spike> getSpikes() {return this.spikes;}
    public int getAvailableStars() {return this.availableStars;}
    public List<DartTrap> getDartTraps() {return this.dartTraps;}
    public List<Collectable> getCollectables() {return collectables;}
    public List<PowerUp> getPowerUps() {return powerUps;}
    public List<String> getGlobalPositions() {return this.globalPositions; }
    public List<Element> getGlobalElements() { return this.globalElements; }
}
