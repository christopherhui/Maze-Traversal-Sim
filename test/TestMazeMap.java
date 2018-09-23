import org.junit.jupiter.api.Test;
import ui.MazeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMazeMap {

    @Test
    public void createSmallestMaze() {
        MazeMap maze = new MazeMap(2,2);
        assertEquals(4, maze.get_area());

        assertEquals("O O\nO O", maze.toString());
    }
}
