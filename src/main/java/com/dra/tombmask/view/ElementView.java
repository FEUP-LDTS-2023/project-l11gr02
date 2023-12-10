package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface ElementView<T>{
    void draw(T element, GUI gui);
}
