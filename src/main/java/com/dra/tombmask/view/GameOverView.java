package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.GameOver;
import com.dra.tombmask.utils.MENU_OPTION;

import java.io.IOException;

public class GameOverView extends AbstractView<GameOver>{
    public GameOverView(GameOver gameOver){
        super(gameOver);
    }
    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.drawText(4,5,"GAME OVER");
        gui.drawSelectable(6,7,"RETRY",getModel().getCurrentOption() == MENU_OPTION.PLAY);
        gui.drawSelectable(6,9,"EXIT",getModel().getCurrentOption() == MENU_OPTION.EXIT);
    }
}
