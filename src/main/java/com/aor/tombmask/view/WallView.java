package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Wall;

public class WallView implements ElementView<Wall>{
    public void draw(Wall wall, GUI gui){
        gui.drawWall(wall.getPosition());
    }
}
