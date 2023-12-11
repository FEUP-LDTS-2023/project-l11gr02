package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Mask;
import com.dra.tombmask.model.Store;
import com.dra.tombmask.utils.ElementsSymbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class MaskView implements ElementView<Mask>{
    static public String maskSymbol = ElementsSymbol.defaultMask.symbol;

    public MaskView() throws IOException {
        Store store = new Store();
        maskSymbol = store.maskSymbolMap.get(store.getSelectedMask());
    }

    public void draw(Mask mask, GUI gui){
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        TerminalPosition terminalPosition = new TerminalPosition(mask.getPosition().getX(), mask.getPosition().getY());
        textGraphics.putString(terminalPosition, !mask.isShielded() ? maskSymbol : ElementsSymbol.getShielded(maskSymbol));
    }
}
