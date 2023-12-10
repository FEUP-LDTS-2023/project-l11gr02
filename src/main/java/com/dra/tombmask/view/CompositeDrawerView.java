package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;

import java.util.List;

public class CompositeDrawerView {

    GUI gui;

    public CompositeDrawerView(GUI gui){
        this.gui = gui;
    }

    public <T> void draw(T element,ElementView<T> elementElementView){
        elementElementView.draw(element,gui);
    }
    public <T> void draw(List<T> elements,ElementView<T> elementElementView){
        elements.forEach((e) -> elementElementView.draw(e,gui));
    }
}
