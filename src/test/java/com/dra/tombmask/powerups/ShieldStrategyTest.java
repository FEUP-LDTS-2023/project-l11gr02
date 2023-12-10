package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Hero;
import com.dra.tombmask.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ShieldStrategyTest {
    @Test
    public void executeTest() {
        Arena arena = Mockito.mock(Arena.class);
        ShieldStrategy shieldStrategy = new ShieldStrategy();
        Hero hero = Mockito.mock(Hero.class);
        Mockito.when(arena.getHero()).thenReturn(hero);
        shieldStrategy.execute(arena);

        Mockito.verify(arena,Mockito.times(1)).getHero();
        Mockito.verify(hero,Mockito.times(1)).setShieldedTime(10.0);
    }
}
