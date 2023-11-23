package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Bat;

public class BatView implements ElementView<Bat>{
    public void draw(Bat bat, GUI gui){
        gui.drawBat(bat.getPosition());
    }
}
