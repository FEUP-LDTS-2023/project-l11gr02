package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinTest {
    @Test
    public void symbolTest(){
        Coin coin = new Coin(0,0);
        Assertions.assertEquals(coin.getSymbol(),"c");
    }
    @Test
    public void toStringTest(){
        Coin coin = new Coin(1,1);
        Assertions.assertEquals("(1, 1)",coin.toString());
    }
}
