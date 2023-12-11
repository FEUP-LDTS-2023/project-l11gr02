package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;

public class ShieldStrategy extends PowerUpStrategy{
    final double SHIELD_TIME = 10.0;
    public void execute(Tomb tomb){
        tomb.getMask().setShieldedTime(SHIELD_TIME);
    }
}
