import blocks.EmptySpace;
import blocks.End;
import blocks.SpecializedBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpecializedBlock {

    @Test
    public void testEmptySpace() {
        SpecializedBlock es = new EmptySpace();
        assertEquals("White", es.get_background_color());
        assertEquals(0, es.get_status());
    }

    @Test
    public void testEnd() {
        SpecializedBlock es = new End();
        assertEquals("White", es.get_background_color());
    }
}
