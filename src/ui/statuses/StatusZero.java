package ui.statuses;

import model.ListOfMaze;
import ui.Messages;

import java.util.Scanner;

public class StatusZero {
    private Messages messages;

    public StatusZero() {
        this.messages = new Messages();
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom (in the future), st
    // EFFECTS: Runs the creation, access of a maze and termination of program
    public void run_status_zero(Scanner keys, String key, ListOfMaze lom, CurrentStatus st) {
        try {
            int cmd = Integer.parseInt(key);
            switch (cmd) {
                case 1:
                    st.change_status(1);
                    messages.maze_create_msg();
                    break;
                case 2:
                    if (lom.get_num_mazes() == 0)
                        System.out.println("No mazes available!");
                    else {
                        System.out.println("What maze do you want to open?");
                        messages.num_mazes_avail(lom);
                        st.change_status(2);
                    }
                    break;
                case 3:
                    System.out.println("Closing...\nThank you for using maze simulator!");
                    keys.close();
                    System.exit(0);  // Required as keys.hasNextInt() throws IllegalException if scanner closes
                    break;
                default:
                    System.out.println("Incorrect command, please try again.");
            }
        } catch (Exception e) {
            System.out.println("Incorrect command, please try again.");
        }
    }
}
