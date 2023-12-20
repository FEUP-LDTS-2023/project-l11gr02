package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;

public class ShieldStrategy extends PowerUpStrategy{
    final double SHIELD_TIME = 10.0;
    @Override
    public void execute(Arena arena){
        arena.getMask().setShieldedTime(SHIELD_TIME);
    }
}
