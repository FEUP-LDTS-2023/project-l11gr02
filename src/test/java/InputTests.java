import com.dra.tombmask.GUI.GUI;
import com.dra.tombmask.utils.ACTION;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTests {
    GUI gui;

    public InputTests() throws IOException {
        this.gui = new GUI();
    }

    @Test
    public void userInputUPTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        assertEquals(gui.getAction(keyStroke), ACTION.UP);
    }

    @Test
    public void userInputDOWNTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        assertEquals(gui.getAction(keyStroke), ACTION.DOWN);
    }

    @Test
    public void userInputLEFTTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        assertEquals(gui.getAction(keyStroke), ACTION.LEFT);
    }

    @Test
    public void userInputRIGHTTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        assertEquals(gui.getAction(keyStroke), ACTION.RIGHT);
    }

    @Test
    public void userInputEXITTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        assertEquals(gui.getAction(keyStroke), ACTION.EXIT);
    }

    @Test
    public void userInputSELECTTest() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        assertEquals(gui.getAction(keyStroke), ACTION.ENTER);
    }
}
