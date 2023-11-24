package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Bat;

public class BatView implements ElementView<Bat>{
    public void draw(Bat bat, GUI gui){
        gui.drawBat(bat.getPosition());
    }
}
