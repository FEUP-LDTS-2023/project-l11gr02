package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Mask;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShieldStrategyTest {
    @Test
    public void executeTest() {
        Arena arena = Mockito.mock(Arena.class);
        ShieldStrategy shieldStrategy = new ShieldStrategy();
        Mask mask = Mockito.mock(Mask.class);
        Mockito.when(arena.getMask()).thenReturn(mask);
        shieldStrategy.execute(arena);

        Mockito.verify(arena,Mockito.times(1)).getMask();
        Mockito.verify(mask,Mockito.times(1)).setShieldedTime(10.0);
    }
}
