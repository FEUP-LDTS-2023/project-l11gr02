package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Tomb;
import com.dra.tombmask.model.Bat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class FreezeStrategyTest {
    @Test
    public void executeTest() {
        Tomb tomb = Mockito.mock(Tomb.class);
        FreezeStrategy freezeStrategy = new FreezeStrategy();
        Bat bat1 = Mockito.mock(Bat.class);
        Bat bat2 = Mockito.mock(Bat.class);
        Bat bat3 = Mockito.mock(Bat.class);
        Mockito.when(tomb.getBats()).thenReturn(Arrays.asList(bat1,bat2,bat3));
        freezeStrategy.execute(tomb);

        Mockito.verify(tomb,Mockito.times(1)).getBats();
        Mockito.verify(bat1,Mockito.times(1)).setTimeout(5.0);
        Mockito.verify(bat2,Mockito.times(1)).setTimeout(5.0);
        Mockito.verify(bat3,Mockito.times(1)).setTimeout(5.0);
    }
}
