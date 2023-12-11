package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;

public class CoinMagnetStrategy extends PowerUpStrategy{
    final double MAGNET_TIME = 10.0;
    @Override
    public void execute(Tomb tomb) {
        tomb.getMask().setMagnetTime(MAGNET_TIME);
    }
}
