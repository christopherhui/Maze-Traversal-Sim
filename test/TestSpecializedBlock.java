import blocks.EmptySpace;
import blocks.End;
import blocks.Location;
import blocks.SpecializedBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpecializedBlock {

    @Test
    public void testEmptySpace() {
        SpecializedBlock es = new EmptySpace();
        assertEquals("White", es.get_background_color());
        assertEquals(0, es.get_status());
        assertEquals(null, es.get_text_color());
    }

    @Test
    public void testEnd() {
        SpecializedBlock e = new End();
        assertEquals("White", e.get_background_color());
        assertEquals(0, e.get_status());
        assertEquals("Blue", e.get_text_color());
    }

    @Test
    public void testLocation() {
        SpecializedBlock l = new Location();
        assertEquals("Green", l.get_background_color());
        assertEquals(0, l.get_status());
        assertEquals(null,l.get_text_color());
    }
}
