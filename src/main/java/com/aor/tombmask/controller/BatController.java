package com.aor.tombmask.controller;

import com.aor.tombmask.GUI.GUI;
import com.aor.tombmask.Game;
import com.aor.tombmask.model.Arena;
import com.aor.tombmask.model.Bat;
import com.aor.tombmask.model.Position;
import com.aor.tombmask.utils.ACTION;

import java.io.IOException;

public class BatController extends AbstractController<Arena>{
    public BatController(Arena arena){
        super(arena);
    }

    private void moveRight(Bat bat, Game game, GUI gui, int x, int y) throws IOException, InterruptedException {
        while (true){
            x++;
            if(!getModel().isEmpty(new Position(x,y))) break;
            if(getModel().isEmpty(new Position(x,y))){
                bat.setPosition(new Position(x,y));
                game.gameView.draw(gui);
                Thread.sleep(5);
                continue;
            }
            break;
        }
    }

    @Override
    public void executeState(Game game, ACTION action, GUI gui) throws IOException, InterruptedException {
        while(game.getState() != null){
            for(Bat bat : getModel().getBats()){
                int x = bat.getPosition().getX();
                int y = bat.getPosition().getY();
                moveRight(bat, game, gui, x, y);
            }
        }
    }
}
