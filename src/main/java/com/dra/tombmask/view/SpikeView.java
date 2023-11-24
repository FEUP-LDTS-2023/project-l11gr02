package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Spike;

public class SpikeView implements ElementView<Spike>{
    @Override
    public void draw(Spike spike, GUI gui) {
        gui.drawSpike(spike.getPosition());
    }
}
