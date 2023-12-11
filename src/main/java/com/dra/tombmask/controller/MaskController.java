package com.dra.tombmask.controller;

import com.dra.tombmask.Game;
import com.dra.tombmask.model.*;
import com.dra.tombmask.state.GameState;
import com.dra.tombmask.state.MenuState;
import com.dra.tombmask.utils.ACTION;
import com.dra.tombmask.utils.DIRECTION;

import java.io.IOException;

public class MaskController extends AbstractController<Arena>{
    private Arena arena;
    private final Mask mask = getModel().getMask();
    public MaskController(Arena arena){
        super(arena);
        this.arena = arena;
    }

    public Element moveMask(){
        if(mask.isShielded()) mask.setShieldedTime(mask.getShieldedTime() - 0.08);
        if(mask.isMagnet()) mask.setMagnetTime(mask.getMagnetTime() - 0.08);
        int x = mask.getPosition().getX();
        int y = mask.getPosition().getY();
        switch (mask.getDirection()){
            case UP:
                y--;
                if(!getModel().isEmpty(new Position(x,y))){
                    mask.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                mask.setPosition(new Position(x,y));
                break;
            case DOWN:
                y++;
                if(!getModel().isEmpty(new Position(x,y))){
                    mask.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                mask.setPosition(new Position(x,y));
                break;
            case LEFT:
                x--;
                if(!getModel().isEmpty(new Position(x,y))){
                    mask.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                mask.setPosition(new Position(x,y));
                break;
            case RIGHT:
                x++;
                if(!getModel().isEmpty(new Position(x,y))){
                    mask.setDirection(DIRECTION.IDLE);
                    break;
                }
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                mask.setPosition(new Position(x,y));
                break;
            case IDLE:
                if(checkCollision(new Position(x, y)) != null) return checkCollision(new Position(x,y));
                mask.setPosition(new Position(x,y));
                break;
        }
        return null;
    }

    public Element checkCollision(Position position){
        Element element = getModel().getElementAtPosition(position);
        if(element instanceof PowerUp){
            ((PowerUp) element).getStrategy().execute(getModel());
            getModel().getGlobalElements().remove(element);
            return null;
        }
        else if(element instanceof Collectable){
            ((Collectable) element).collect(getModel());
            return null;
        }
        else if(element instanceof Trampoline){
            handleTrampolineCollision((Trampoline) element);
            return null;
        }
        if(Mask.collected_stars != Arena.availableStars && element instanceof EndLevel) return null;
        return element;
    }
    public void handleTrampolineCollision(Trampoline trampoline){
        DIRECTION maskDirection = getModel().getMask().getDirection();
        Mask mask = getModel().getMask();
        DIRECTION newMaskDirection;
        switch (trampoline.getCorner()){
            case TOPRIGHT:
                newMaskDirection = maskDirection == DIRECTION.RIGHT ? DIRECTION.DOWN : DIRECTION.LEFT;
                mask.setDirection(newMaskDirection);
                break;
            case TOPLEFT:
                newMaskDirection = maskDirection == DIRECTION.LEFT ? DIRECTION.DOWN : DIRECTION.RIGHT;
                mask.setDirection(newMaskDirection);
                break;
            case BOTRIGHT:
                newMaskDirection = maskDirection == DIRECTION.RIGHT ? DIRECTION.UP : DIRECTION.LEFT;
                mask.setDirection(newMaskDirection);
                break;
            case BOTLEFT:
                newMaskDirection = maskDirection == DIRECTION.LEFT ? DIRECTION.UP : DIRECTION.RIGHT;
                mask.setDirection(newMaskDirection);
                break;
        }
    }

    public void collectAdjacentCoins(){
        int maskX = mask.getPosition().getX();
        int maskY = mask.getPosition().getY();
        for(int x = maskX - 1; x <= maskX + 1; x++){
            for(int y = maskY - 1; y <= maskY + 1; y++){
                Element e = getModel().getElementAtPosition(new Position(x,y));
                if(e instanceof Collectable) ((Collectable) e).collect(getModel());
            }
        }
    }


    @Override
    public void executeState(Game game, ACTION action) throws IOException, InterruptedException {
        switch (action){
            case UP:
                if(mask.getDirection() != DIRECTION.IDLE) break;
                mask.setDirection(DIRECTION.UP);
                break;
            case DOWN:
                if(mask.getDirection() != DIRECTION.IDLE) break;
                mask.setDirection(DIRECTION.DOWN);
                break;
            case LEFT:
                if(mask.getDirection() != DIRECTION.IDLE) break;
                mask.setDirection(DIRECTION.LEFT);
                break;
            case RIGHT:
                if(mask.getDirection() != DIRECTION.IDLE) break;
                mask.setDirection(DIRECTION.RIGHT);
                break;
        }
        if(mask.isMagnet()) collectAdjacentCoins();
        if(moveMask() instanceof EndLevel) {
            game.setCurrentArena(game.currentArena + 1);
            try {
                String path = "./src/main/resources/levels/level"+game.currentArena;
                game.setState(new GameState(new Arena(60, 30,path)));
            }catch (IOException e){
                game.setState(new MenuState());
                game.setCurrentArena(1);
            }
        }
        else if((moveMask() instanceof Bat || moveMask() instanceof Spike || moveMask() instanceof Dart)){
            if(mask.isShielded()){
                mask.setShieldedTime(0.0);
            }
            else{
                game.setState(new MenuState());
            }
        }
    }
}
