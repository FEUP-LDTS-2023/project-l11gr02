package com.dra.tombmask.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void symbolTest(){
        Element element = new Element(1,1);
        element.setSymbol("W");

        Assertions.assertEquals("W",element.getSymbol());
    }

    @Test
    public void colourTest(){
        Element element = new Element(1,1);
        element.setColor("#FFFF00");

        Assertions.assertEquals("#FFFF00",element.getColor());
    }

    @Test
    public void equalsTest(){
        Element e2 = new Element(1,1);
        Element e3 = new Element(1,2);
        Element e4 = new Element(1,1);
        String s = "afg";

        Assertions.assertNotEquals(e4, null);
        Assertions.assertNotEquals(e4, s);
        Assertions.assertEquals(e4, e2);
        Assertions.assertNotEquals(e4, e3);
    }
}
