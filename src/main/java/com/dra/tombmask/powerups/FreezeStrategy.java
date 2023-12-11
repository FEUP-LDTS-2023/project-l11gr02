package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.powerups.PowerUpStrategy;

public class FreezeStrategy extends PowerUpStrategy {
    final double FREEZE_TIMEOUT = 5;
    @Override
    public void execute(Arena arena) {
        arena.getBats().forEach((bat -> {
            bat.setTimeout(FREEZE_TIMEOUT);
        }));
    }
}
