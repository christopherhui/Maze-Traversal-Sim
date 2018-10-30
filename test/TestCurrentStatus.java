import ui.statuses.CurrentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCurrentStatus {
    private int status;
    private CurrentStatus s;

    @BeforeEach
    public void createStatus() {
        s = new CurrentStatus();
    }

    @Test
    public void changeStatusZero() {
        s.change_status(0);
        assertEquals(0, s.get_status());
    }

    @Test
    public void changeStatusOne() {
        s.change_status(1);
        assertEquals(1, s.get_status());
    }
}
