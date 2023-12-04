package com.dra.tombmask.model;

import com.dra.tombmask.powerups.PowerUpStrategy;

public class PowerUp extends Element{
    private final PowerUpStrategy strategy;

    public PowerUp(Position position, PowerUpStrategy strategy) {
        super(position.getX(), position.getY());
        this.strategy = strategy;
    }

    public PowerUpStrategy getStrategy() {
        return strategy;
    }

}
