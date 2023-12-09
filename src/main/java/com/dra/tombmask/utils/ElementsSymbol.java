package com.dra.tombmask.utils;

import com.dra.tombmask.model.PowerUp;
import com.dra.tombmask.powerups.CoinMagnetStrategy;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.PowerUpStrategy;
import com.dra.tombmask.powerups.ShieldStrategy;

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
    shieldPowerUp("g"),
    freezePowerUp("f"),
    trampolineTR("y"),
    trampolineTL("x"),
    trampolineBL("t"),
    trampolineBR("u"),
    magnetPowerUp("m"),
    starCollectable("*"),
    pointCollectable("."),
    coinCollectable("o"),
    wallElement("w"),
    dartTrapLeft("r"),
    dartTrapRight("q"),
    dartTrapUp("k"),
    dartTrapDown("j"),
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
    public static String getTrampolineCorner(CORNER corner) {
        switch (corner) {
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
    public static String getPowerUp(PowerUp powerUp){
        if(powerUp.getStrategy() instanceof FreezeStrategy) return freezePowerUp.symbol;
        if(powerUp.getStrategy() instanceof ShieldStrategy) return shieldPowerUp.symbol;
        if(powerUp.getStrategy() instanceof CoinMagnetStrategy) return magnetPowerUp.symbol;
        return "";
    }
}
