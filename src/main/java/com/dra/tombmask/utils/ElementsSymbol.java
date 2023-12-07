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
    public String getShielded(String value){
        if(Objects.equals(ninjaHero.symbol,value)) return ninjaShieldedHero.symbol;
        if(Objects.equals(amongusHero.symbol,value)) return amongusShieldedHero.symbol;
        if(Objects.equals(crowHero.symbol,value)) return crowShieldedHero.symbol;
        return defaultShieldedHero.symbol;
    }
}
