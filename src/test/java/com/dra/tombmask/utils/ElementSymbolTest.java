package com.dra.tombmask.utils;

import com.dra.tombmask.model.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementSymbolTest {
    @Test
    public void testGetShielded() {
        Assertions.assertEquals("p", ElementsSymbol.ninjaHero.getShielded("n"));
        Assertions.assertEquals("z", ElementsSymbol.amongusHero.getShielded("a"));
        Assertions.assertEquals("d", ElementsSymbol.crowHero.getShielded("c"));
        Assertions.assertEquals("i", ElementsSymbol.defaultHero.getShielded("someOtherValue"));
    }
}
