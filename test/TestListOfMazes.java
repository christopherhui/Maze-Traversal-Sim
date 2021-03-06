import exceptions.IllegalCharacterException;
import model.ListOfMaze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.MazeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestListOfMazes {
    private ListOfMaze lom;

    @BeforeEach
    public void create_before() {
        lom = new ListOfMaze();
    }

    @Test
    public void test_mazes() throws IllegalCharacterException {
        assertEquals(0, lom.get_num_mazes());
        MazeMap maze1 = new MazeMap(4,3);
        MazeMap maze2 = new MazeMap(3, 5);

        lom.add_maze(maze1);
        lom.add_maze(maze2);
        assertEquals(2, lom.get_num_mazes());
        lom.remove_maze(1);
        assertEquals(1, lom.get_num_mazes());
    }
}
