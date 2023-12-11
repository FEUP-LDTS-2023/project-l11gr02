package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.Mask;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CoinMagnetStrategyTest {
    @Test
    public void executeTest() {
        Tomb tomb = Mockito.mock(Tomb.class);
        CoinMagnetStrategy coinMagnetStrategy = new CoinMagnetStrategy();
        Mask mask = Mockito.mock(Mask.class);
        Mockito.when(tomb.getMask()).thenReturn(mask);
        coinMagnetStrategy.execute(tomb);

        Mockito.verify(tomb,Mockito.times(1)).getMask();
        Mockito.verify(mask,Mockito.times(1)).setMagnetTime(10.0);
    }
}
