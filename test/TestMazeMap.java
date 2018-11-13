import exceptions.IllegalCharacterException;
import org.junit.jupiter.api.Test;
import model.MazeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMazeMap {

    @Test
    public void createSmallestMaze() throws IllegalCharacterException {
        MazeMap maze = new MazeMap(2,2);
        assertEquals(4, maze.get_area());

        assertEquals("O O\nO O", maze.toString());
    }

    @Test
    public void createLargeHSmallW() throws IllegalCharacterException {
        MazeMap maze = new MazeMap(4,7);
        assertEquals(28, maze.get_area());
        assertEquals("O O O O\nO O O O\nO O O O\n" +
                "O O O O\nO O O O\nO O O O\nO O O O", maze.toString());
    }

    @Test
    public void createSmallHLargeW() throws IllegalCharacterException {
        MazeMap maze = new MazeMap(6, 10);
        assertEquals(60, maze.get_area());
        assertEquals("O O O O O O\nO O O O O O\nO O O O O O\n" +
                "O O O O O O\nO O O O O O\nO O O O O O\n" +
                "O O O O O O\nO O O O O O\nO O O O O O\n" +
                "O O O O O O", maze.toString());
    }
}
