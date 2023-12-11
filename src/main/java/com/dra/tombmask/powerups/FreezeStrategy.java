package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;

public class FreezeStrategy extends PowerUpStrategy {
    final double FREEZE_TIMEOUT = 5;
    @Override
    public void execute(Tomb tomb) {
        tomb.getBats().forEach((bat -> {
            bat.setTimeout(FREEZE_TIMEOUT);
        }));
    }
}
