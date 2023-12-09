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
    magnetPowerUp("m"),
    starCollectable("*"),
    pointCollectable("."),
    coinCollectable("o"),
    wallElement("w"),
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

    public static String getPowerUp(PowerUp powerUp){
        if(powerUp.getStrategy() instanceof FreezeStrategy) return freezePowerUp.symbol;
        if(powerUp.getStrategy() instanceof ShieldStrategy) return shieldPowerUp.symbol;
        if(powerUp.getStrategy() instanceof CoinMagnetStrategy) return magnetPowerUp.symbol;
        return "";
    }
}
