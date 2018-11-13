import model.BlockConverter;
import model.MazeMap;
import model.RectangularMazes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.saveload.LoadState;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoadState {
    RectangularMazes lom;
    LoadState load;


    @BeforeEach
    public void start_before() {
        load = new LoadState();
        lom = new RectangularMazes();
    }

    // Only works if save-file matches load state!
    @Test
    public void test_mazes() {
        load.load(lom);
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
        load.load(lom);
        assertEquals(lom.get_num_mazes(), 3);
    }
}
