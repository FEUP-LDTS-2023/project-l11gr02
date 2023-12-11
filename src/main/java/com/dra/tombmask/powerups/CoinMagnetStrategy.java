package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;

public class CoinMagnetStrategy extends PowerUpStrategy{
    final double MAGNET_TIME = 10.0;
    @Override
    public void execute(Arena arena) {
        arena.getMask().setMagnetTime(MAGNET_TIME);
    }
}
