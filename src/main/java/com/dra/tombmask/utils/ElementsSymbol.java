package com.dra.tombmask.utils;

import java.util.Objects;

public enum ElementsSymbol {
    batEnemy("b"),
    defaultHero("h"),
    defaultShieldedHero("i"),
    ninjaHero("n"),
    ninjaShieldedHero("p"),
    crowHero("c"),
    crowShieldedHero("d"),
    amongusHero("a"),
    amongusShieldedHero("z"),
    shieldPowerUp("s"),
    freezePowerUp("f"),
    trampolineTR("y"),
    trampolineTL("x"),
    trampolineBL("t"),
    trampolineBR("u"),
    starCollectable("*"),
    pointCollectable("."),
    coinCollectable("o"),
    wallElement("w"),
    dartTrapLeft("q"),
    dartTrapRight("r"),
    dartTrapUp("j"),
    dartTrapDown("k"),
    spikeElement("w"),
    endLevelElement("e");
    public final String symbol;
    ElementsSymbol(String symbol) {
        this.symbol = symbol;
    }
    public static String getShielded(String value){
        if(Objects.equals(ninjaHero.symbol,value)) return ninjaShieldedHero.symbol;
        if(Objects.equals(amongusHero.symbol,value)) return amongusShieldedHero.symbol;
        if(Objects.equals(crowHero.symbol,value)) return crowShieldedHero.symbol;
        return defaultShieldedHero.symbol;
    }

    public static String getTrapDirection(DIRECTION direction){
        switch (direction){
            case LEFT -> {
                return dartTrapLeft.symbol;
            }
            case RIGHT -> {
                return dartTrapRight.symbol;
            }
            case UP -> {
                return dartTrapUp.symbol;
            }
            case DOWN -> {
                return dartTrapDown.symbol;
            }
        }
        return "";
    }
    public static String getTrampolineCorner(CORNER corner){
        switch (corner){
            case TOPLEFT -> {
                return trampolineTL.symbol;
            }
            case TOPRIGHT -> {
                return trampolineTR.symbol;
            }
            case BOTLEFT -> {
                return trampolineBL.symbol;
            }
            case BOTRIGHT -> {
                return trampolineBR.symbol;
            }
        }
        return "";
    }
}
