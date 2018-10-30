import model.blocks.Block;
import model.blocks.EmptySpace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlock {

    @Test
    public void testExampleEmptySpace() {
        Block es = new EmptySpace();
        assertEquals(0, es.get_status());
        assertEquals("White", es.get_background_color());
        assertEquals("O", es.to_display());
    }
}
