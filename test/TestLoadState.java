import model.RectangularMazes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.LoadState;

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
        assertEquals("O O\nO O", lom.get_maze(0).toString());
        assertEquals("O O O O O\nO O O O O\nO O O O O", lom.get_maze(1).toString());
    }

    @Test
    public void failed_maze() {
        load.load(lom);
        assertEquals(lom.get_num_mazes(), 3);
    }
}
