package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.utils.*;


import java.io.IOException;

public abstract class AbstractMenuView {
    private String title;

    public abstract void draw(GUI gui, MENU_OPTION selected) throws IOException;
}
