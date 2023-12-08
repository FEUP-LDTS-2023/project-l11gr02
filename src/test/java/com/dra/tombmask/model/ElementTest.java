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
        Element e1 = null;
        Element e2 = new Element(1,1);
        Element e3 = new Element(1,2);
        Element e4 = new Element(1,1);
        String s = "afg";

        Assertions.assertFalse(e4.equals(e1));
        Assertions.assertFalse(e4.equals(s));
        Assertions.assertTrue(e4.equals(e2));
        Assertions.assertFalse(e4.equals(e3));
    }
}
