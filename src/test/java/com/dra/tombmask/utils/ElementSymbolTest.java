package com.dra.tombmask.utils;

import com.dra.tombmask.model.Element;
import com.dra.tombmask.model.Position;
import com.dra.tombmask.model.PowerUp;
import com.dra.tombmask.powerups.CoinMagnetStrategy;
import com.dra.tombmask.powerups.FreezeStrategy;
import com.dra.tombmask.powerups.ShieldStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementSymbolTest {
    @Test
    public void testGetShielded() {
        Assertions.assertEquals("p", ElementsSymbol.getShielded("n"));
        Assertions.assertEquals("z", ElementsSymbol.getShielded("a"));
        Assertions.assertEquals("d", ElementsSymbol.getShielded("c"));
        Assertions.assertEquals("i", ElementsSymbol.getShielded("someOtherValue"));
    }

    @Test
    public void testGetPowerUp() {
        PowerUp freezePowerUp = new PowerUp(new Position(1,1), new FreezeStrategy());
        PowerUp shieldPowerUp = new PowerUp(new Position(2,2),new ShieldStrategy());
        PowerUp magnetPowerUp = new PowerUp(new Position(3,3),new CoinMagnetStrategy());

        Assertions.assertEquals("f", ElementsSymbol.getPowerUp(freezePowerUp));
        Assertions.assertEquals("g", ElementsSymbol.getPowerUp(shieldPowerUp));
        Assertions.assertEquals("m", ElementsSymbol.getPowerUp(magnetPowerUp));
    }

    @Test
    public void testGetTrapDirection(){
        Assertions.assertEquals("r",ElementsSymbol.getTrapDirection(DIRECTION.LEFT));
        Assertions.assertEquals("q",ElementsSymbol.getTrapDirection(DIRECTION.RIGHT));
        Assertions.assertEquals("k",ElementsSymbol.getTrapDirection(DIRECTION.UP));
        Assertions.assertEquals("j",ElementsSymbol.getTrapDirection(DIRECTION.DOWN));
        Assertions.assertEquals("",ElementsSymbol.getTrapDirection(DIRECTION.IDLE));
    }

    @Test
    public void testGetTrampolineCorner(){
        Assertions.assertEquals("x",ElementsSymbol.getTrampolineCorner(CORNER.TOPLEFT));
        Assertions.assertEquals("y",ElementsSymbol.getTrampolineCorner(CORNER.TOPRIGHT));
        Assertions.assertEquals("t",ElementsSymbol.getTrampolineCorner(CORNER.BOTLEFT));
        Assertions.assertEquals("u",ElementsSymbol.getTrampolineCorner(CORNER.BOTRIGHT));
    }
}
