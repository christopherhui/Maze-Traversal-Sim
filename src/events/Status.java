package events;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private int status;

    public Status() {
        this.status = 0;
    }

    public int get_status() {
        return status;
    }

    public void change_status(int i) {
        status = i;
    }
}
