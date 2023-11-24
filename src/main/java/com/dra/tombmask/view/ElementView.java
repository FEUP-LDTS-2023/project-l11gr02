package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;

public interface ElementView<T>{
    void draw(T element, GUI gui);
}
