import blocks.Display;
import blocks.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDisplay {

    @Test
    public void testExampleWall() {
        Display w = new Wall();
        assertEquals("W", w.to_display());
    }
}
