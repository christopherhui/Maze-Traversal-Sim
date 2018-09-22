package events;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private int status;

    // EFFECTS: Status is initially at 0
    public Status() {
        this.status = 0;
    }

    public int get_status() {
        return status;
    }

    // REQUIRES: Number must be either 0 or 1 (for now)
    // MODIFIES: this
    // EFFECTS: Changes the status to some number
    public void change_status(int i) {
        status = i;
    }
}
