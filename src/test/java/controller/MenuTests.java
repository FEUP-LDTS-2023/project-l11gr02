package controller;

import com.dra.tombmask.model.Menu;
import com.dra.tombmask.utils.MENU_OPTION;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTests {
    @Test
    public void defaultSelectedOptionTest() {
        Menu menu = new Menu();
        assertEquals(MENU_OPTION.PLAY,menu.getCurrentOption());
    }
    @Test
    public void movingSelectionMenuTest() {
        Menu menu = new Menu();
        menu.upMenu();
        assertEquals(MENU_OPTION.PLAY,menu.getCurrentOption());
        menu.downMenu();
        assertEquals(MENU_OPTION.EXIT,menu.getCurrentOption());
        menu.downMenu();
        menu.upMenu();
        assertEquals(MENU_OPTION.PLAY,menu.getCurrentOption());
        menu.downMenu();
        menu.downMenu();
        assertEquals(MENU_OPTION.EXIT,menu.getCurrentOption());
    }
    @Test
    public void isSelectedTest() {
        Menu menu = new Menu();
        assertFalse(menu.isSelected(MENU_OPTION.EXIT));
        assertTrue(menu.isSelected(MENU_OPTION.PLAY));

        menu.downMenu();
        assertTrue(menu.isSelected(MENU_OPTION.EXIT));
        assertFalse(menu.isSelected(MENU_OPTION.PLAY));
    }
}
