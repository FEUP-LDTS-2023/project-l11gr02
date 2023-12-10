package com.dra.tombmask.powerups;

import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Hero;
import com.dra.tombmask.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CoinMagnetStrategyTest {
    @Test
    public void executeTest() {
        Arena arena = Mockito.mock(Arena.class);
        CoinMagnetStrategy coinMagnetStrategy = new CoinMagnetStrategy();
        Hero hero = Mockito.mock(Hero.class);
        Mockito.when(arena.getHero()).thenReturn(hero);
        coinMagnetStrategy.execute(arena);

        Mockito.verify(arena,Mockito.times(1)).getHero();
        Mockito.verify(hero,Mockito.times(1)).setMagnetTime(10.0);
    }
}
