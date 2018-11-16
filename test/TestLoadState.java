import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.MazeMap;
import model.ListOfMaze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.saveload.LoadState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestLoadState {
    ListOfMaze lom;
    LoadState load;


    @BeforeEach
    public void start_before() {
        load = new LoadState();
        lom = new ListOfMaze();
    }

    // Only works if save-file matches load state!
    @Test
    public void test_mazes() {
        load.load(lom, "savefile.txt");
        assertEquals("S O\nO E", lom.get_maze(0).toString());
        assertEquals("S O O O O\nO O O O O\nO O O O E", lom.get_maze(1).toString());
        MazeMap mazeMap = lom.get_maze(0);
        try {
            mazeMap.changeBlock(0, 0, "V");
            assertEquals("V O\nO E", lom.get_maze(0).toString());
        }
        catch (Exception e) {
        }
    }

    @Test
    public void failed_maze() {
        load.load(lom, "savefile.txt");
        assertEquals(lom.get_num_mazes(), 3);
    }
}
