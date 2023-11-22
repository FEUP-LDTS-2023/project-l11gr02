import com.aor.tombmask.model.Position;
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

        assertEquals(expectedHeroPosition.getY(),mapLoader.getHeroPosition().getY());
        assertEquals(expectedHeroPosition.getX(),mapLoader.getHeroPosition().getX());
    }
    @Test
    public void positionBatHandlerTest() throws IOException {
        List<Position> expectedBatPositions = new ArrayList<>();
        expectedBatPositions.add(new Position(7,2));
        expectedBatPositions.add(new Position(2,6));

        MapLoader mapLoader = new MapLoader(pathLevel1);

        for(int i = 0; i < expectedBatPositions.size(); i++) {
            Position p1 = expectedBatPositions.get(i);
            Position p2 = mapLoader.getBatPositions().get(i);
            assertEquals(p1.getX(),p2.getX());
            assertEquals(p1.getY(),p2.getY());
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
        for(Position position : mapLoader.getWallPositions()) {
            assert expectedWallPositions.contains(position);
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

        for(Position expectedSpike : expectedSpikePositions) {
            assert mapLoader.getSpikePositions().contains(expectedSpike);
        }
    }
}
