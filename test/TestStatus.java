import events.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStatus {
    private int status;
    private Status s;

    @BeforeEach
    public void createStatus() {
        s = new Status();
    }

    @Test
    public void changeStatusZero() {
        s.change_status(0);
        assertEquals(s.get_status(), 0);
    }

    @Test
    public void changeStatusOne() {
        s.change_status(1);
        assertEquals(s.get_status(), 1);
    }
}
