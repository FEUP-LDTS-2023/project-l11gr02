package com.dra.tombmask.view;

import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.model.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;

public class MainMenuViewTest {
    @Test
    public void drawModelTest() throws IOException {
        Menu menu = new Menu();
        GUI gui = Mockito.mock(GUI.class);
        MainMenuView mainMenuView = new MainMenuView(menu);
        mainMenuView.drawModel(gui);

        Mockito.verify(gui,Mockito.times(1)).drawText(eq(1),eq(5),Mockito.anyString());
        Mockito.verify(gui,Mockito.times(3)).drawSelectable(Mockito.any(Integer.class),Mockito.any(Integer.class),Mockito.anyString(),Mockito.any(Boolean.class));
    }
}
