package com.dra.tombmask.utils;

import com.dra.tombmask.model.PowerUp;
import com.dra.tombmask.powerups.CoinMagnetStrategy;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.ShieldStrategy;

import java.util.Objects;

public enum ElementsSymbol {
    batEnemy("b"),
    defaultMask("h"),
    defaultShieldedMask("i"),
    ninjaMask("n"),
    ninjaShieldedMask("p"),
    crowMask("c"),
    crowShieldedMask("d"),
    amongusMask("a"),
    amongusShieldedMask("z"),
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
        if(Objects.equals(ninjaMask.symbol,value)) return ninjaShieldedMask.symbol;
        if(Objects.equals(amongusMask.symbol,value)) return amongusShieldedMask.symbol;
        if(Objects.equals(crowMask.symbol,value)) return crowShieldedMask.symbol;
        return defaultShieldedMask.symbol;
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
