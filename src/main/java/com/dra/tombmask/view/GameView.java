package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Arena;
import com.dra.tombmask.model.Mask;

import java.io.IOException;

public class GameView extends AbstractView<Arena>{
    public GameView(Arena arena){
        super(arena);
    }

    public void drawModel(CompositeDrawerView compositeDrawerView) throws IOException {
        compositeDrawerView.draw(getModel().getWalls(),new WallView());
        compositeDrawerView.draw(getModel().getMask(), new MaskView());
        compositeDrawerView.draw(getModel().getBats(), new BatView());
        compositeDrawerView.draw(getModel().getSpikes(),new SpikeView());
        if(Mask.collected_stars == Arena.availableStars)
            compositeDrawerView.draw(getModel().getEndLevel(),new EndLevelView());
        compositeDrawerView.draw(getModel().getGlobalElements(),new MiscView());
        compositeDrawerView.draw(getModel().getDartTraps(),new DartTrapView());
        compositeDrawerView.draw(getModel().getDarts(),new DartView());
    }
    @Override
    public void drawModel(GUI gui) throws IOException {
        CompositeDrawerView compositeDrawerView = new CompositeDrawerView(gui);
        drawModel(compositeDrawerView);
        gui.drawText(20, 15, "" + Mask.collected_coins);
    }

}
