package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Mask;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CoinMagnetStrategyTest {
    @Test
    public void executeTest() {
        Arena arena = Mockito.mock(Arena.class);
        CoinMagnetStrategy coinMagnetStrategy = new CoinMagnetStrategy();
        Mask mask = Mockito.mock(Mask.class);
        Mockito.when(arena.getMask()).thenReturn(mask);
        coinMagnetStrategy.execute(arena);

        Mockito.verify(arena,Mockito.times(1)).getMask();
        Mockito.verify(mask,Mockito.times(1)).setMagnetTime(10.0);
    }
}
