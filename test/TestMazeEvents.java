import model.RectangularMazes;
import ui.MazeEvents;
import ui.statuses.CurrentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMazeEvents {
    private MazeEvents me;
    private RectangularMazes lom;
    private CurrentStatus s;
    private Scanner keys;

    @BeforeEach
    public void beforeTest() {
        me = new MazeEvents();
        lom = new RectangularMazes();
        s = new CurrentStatus();
        keys = new Scanner(System.in);
    }

    @Test
    public void testStatusZero() {
        // Testing if 2 case crashes, can't test 3 because sys.exit()
        me.run_status_zero(keys,"2", lom, s);

        // Else cases if wrong command is given
        me.run_status_zero(keys, "4", lom, s);
        me.run_status_zero(keys, "dont crash please", lom, s);
        assertEquals(0, s.get_status());

        // Inputting 1 should change status to 1
        me.run_status_zero(keys,"1", lom, s);
        assertEquals(1, s.get_status());
    }

    @Test
    public void testStatusOneFailCreateMaze() {
        // Testing faulty cases first, if works: creates a maze
        s.change_status(1);
        me.run_status_one("1,1", lom, s);
        assertEquals(1, s.get_status());
        assertEquals(0, lom.get_num_mazes());

        me.run_status_one("10,-5", lom, s);
        assertEquals(1, s.get_status());
        assertEquals(0, lom.get_num_mazes());

        me.run_status_one("1,22", lom, s);
        assertEquals(1, s.get_status());
        assertEquals(0, lom.get_num_mazes());

        me.run_status_one("test", lom, s);
        assertEquals(1, s.get_status());
        assertEquals(0, lom.get_num_mazes());
    }

    @Test
    public void testStatusOneSuccessCreateMazeEdge() {
        s.change_status(1);
        me.run_status_one("2,2", lom, s);
        assertEquals(0, s.get_status());
        assertEquals(1, lom.get_num_mazes());
    }

    @Test
    public void testStatusOneMultipleCreateMaze() {
        s.change_status(1);
        me.run_status_one("3,5", lom, s);
        s.change_status(1);
        me.run_status_one("5,3", lom, s);
        s.change_status(1);
        me.run_status_one("100,230", lom, s);

        assertEquals(0, s.get_status());
        assertEquals(3, lom.get_num_mazes());
    }
}
