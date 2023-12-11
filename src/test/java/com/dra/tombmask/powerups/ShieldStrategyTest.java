package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.Mask;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShieldStrategyTest {
    @Test
    public void executeTest() {
        Tomb tomb = Mockito.mock(Tomb.class);
        ShieldStrategy shieldStrategy = new ShieldStrategy();
        Mask mask = Mockito.mock(Mask.class);
        Mockito.when(tomb.getMask()).thenReturn(mask);
        shieldStrategy.execute(tomb);

        Mockito.verify(tomb,Mockito.times(1)).getMask();
        Mockito.verify(mask,Mockito.times(1)).setShieldedTime(10.0);
    }
}
