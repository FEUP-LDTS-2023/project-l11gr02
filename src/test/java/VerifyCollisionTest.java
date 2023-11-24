import com.dra.tombmask.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyCollisionTest {
    private Arena arena;
    private List<Bat> bats;
    private List<Wall> walls;
    private List<Spike> spikes;
    private EndLevel end;
    private List<Coin> coins;
    private List<Star> stars;
    private List<Point> points;

    @BeforeEach
    public void setup() throws IOException {
        arena = new Arena(30,30,"docs/level1");
    }

    @Test
    public void isBat(){
        bats = new ArrayList<>();
        bats.add(new Bat(2,2));

        arena.setBats(bats);

        Position position = new Position(2,2);

        Assertions.assertEquals(true,arena.isBat(position));
    }

    @Test
    public void isSpike(){
        spikes = new ArrayList<>();
        spikes.add(new Spike(2,2));

        arena.setSpikes(spikes);

        Position position = new Position(1,2);

        Assertions.assertEquals(false,arena.isSpike(position));
    }

    @Test
    public void isCoin(){
        coins = new ArrayList<>();
        coins.add(new Coin(3,2));

        arena.setCoins(coins);

        Position position = new Position(3,2);

        Assertions.assertEquals(true,arena.isCoin(position));
    }

    @Test
    public void isStar(){
        stars = new ArrayList<>();
        stars.add(new Star(3,2));

        arena.setStars(stars);

        Position position = new Position(3,3);

        Assertions.assertEquals(false,arena.isStar(position));
    }

    @Test
    public void isPoint(){
        points = new ArrayList<>();
        points.add(new Point(4,4));

        arena.setPoints(points);

        Position position = new Position(4,4);

        Assertions.assertEquals(true,arena.isPoint(position));
    }

    @Test
    public void isWall(){
        walls = new ArrayList<>();
        walls.add(new Wall(4,4));

        arena.setWalls(walls);

        Position position = new Position(4,4);

        Assertions.assertEquals(true,arena.isWall(position));
    }

    @Test
    public void isEnd(){
        end = new EndLevel(1,1);
        arena.setEnd(end);
        Position position = new Position(1,1);

        Assertions.assertEquals(true,arena.isEnd(position));
    }
}
