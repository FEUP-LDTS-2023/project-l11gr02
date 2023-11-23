import com.aor.tombmask.model.Bat;
import com.aor.tombmask.model.Position;
import com.aor.tombmask.model.Spike;
import com.aor.tombmask.model.Wall;
import com.aor.tombmask.utils.MapLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapLoaderTest {
    static private final String pathLevel1 = "./docs/level1";
    static private final String pathLevel3 = "./docs/level3";
    @Test
    public void openFileTest() throws IOException {
        String upperWall = "WWWWWWWWWW";
        MapLoader mapLoader = new MapLoader(pathLevel1);
        assert mapLoader.getGlobalPositions().contains(upperWall);
    }
    @Test
    public void positionHandlerTest() throws IOException {
        Position expectedHeroPosition = new Position(2,1);

        MapLoader mapLoader = new MapLoader(pathLevel1);

        assertEquals(expectedHeroPosition.getY(),mapLoader.getHero().getPosition().getY());
        assertEquals(expectedHeroPosition.getX(),mapLoader.getHero().getPosition().getX());
    }
    @Test
    public void positionBatHandlerTest() throws IOException {
        List<Bat> expectedBatPositions = new ArrayList<>();
        expectedBatPositions.add(new Bat(7,2));
        expectedBatPositions.add(new Bat(2,6));

        MapLoader mapLoader = new MapLoader(pathLevel1);

        for(int i = 0; i < expectedBatPositions.size(); i++) {
            Bat p1 = expectedBatPositions.get(i);
            Bat p2 = mapLoader.getBats().get(i);
            assertEquals(p1.getPosition().getX(),p2.getPosition().getX());
            assertEquals(p1.getPosition().getY(),p2.getPosition().getY());
        }
    }
    @Test
    public void positionWallHandlerTest() throws IOException {

        MapLoader mapLoader = new MapLoader(pathLevel1);
        List<Position> expectedWallPositions = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            expectedWallPositions.add(new Position(c,0));
            expectedWallPositions.add(new Position(c,10-1));
        }
        for (int r = 0; r < 10 - 1; r++){
            expectedWallPositions.add(new Position(0,r));
            expectedWallPositions.add(new Position(10-1,r));
        }
        for(Wall wall : mapLoader.getWalls()) {
            assert expectedWallPositions.contains(wall.getPosition());
        }
    }
    @Test
    public void positionSpikeHandlerTest() throws IOException {
        MapLoader mapLoader = new MapLoader(pathLevel3);
        List<Position> expectedSpikePositions = new ArrayList<>();

        expectedSpikePositions.add(new Position(22,1));
        expectedSpikePositions.add(new Position(22,2));
        expectedSpikePositions.add(new Position(22,4));
        expectedSpikePositions.add(new Position(22,5));

        for(Spike spike : mapLoader.getSpikes()) {
            assert expectedSpikePositions.contains(spike.getPosition());
        }
    }
}
