package events;

import java.util.ArrayList;

public class Status {
    private boolean status0;
    private boolean status1;
    private boolean status2;

    public Status() {
        this.status0 = true;
        this.status1 = false;
        this.status2 = false;
    }

    public boolean get_status() {
        if (status0) {
            return status0;
        }
        else if (status1) {
            return status1;
        }
        else {
            return status2;
        }
    }

    public void change_status() {
        ;
    }
}
