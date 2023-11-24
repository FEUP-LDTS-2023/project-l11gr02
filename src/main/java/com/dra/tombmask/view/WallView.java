package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Wall;

public class WallView implements ElementView<Wall>{
    public void draw(Wall wall, GUI gui){
        gui.drawWall(wall.getPosition());
    }
}
