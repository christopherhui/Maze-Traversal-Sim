import model.ListofMazes;
import model.MazeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.SaveState;

import java.io.IOException;

public class TestSaveState {
    SaveState st;
    ListofMazes lom;

    @BeforeEach
    public void start_before() {
        st = new SaveState();
        lom = new ListofMazes();
    }

    @Test
    public void add_maze() throws IOException {
        MazeMap m = new MazeMap(2,2);
        MazeMap m1 = new MazeMap(5,3);
        lom.add_maze(m);
        lom.add_maze(m1);
        st.save(lom);
    }
}
