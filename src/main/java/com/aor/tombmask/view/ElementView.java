package com.aor.tombmask.view;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.model.Element;

public interface ElementView<T>{
    void draw(T element, GUI gui);
}
