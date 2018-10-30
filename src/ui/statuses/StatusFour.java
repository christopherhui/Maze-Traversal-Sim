package ui.statuses;

import exceptions.IllegalCharacterException;
import ui.CurrentMaze;
import ui.Messages;

public class StatusFour {
    private Messages messages;

    public StatusFour() {
        this.messages = new Messages();
    }

    public void run_status_four(CurrentMaze cm, String key, CurrentStatus st) throws IllegalCharacterException {
        if (key.equals("back")) {
            st.change_status(3);
            System.out.println("Going back to Maze...");
            messages.maze_options_msg();
        }
        else {
            try {
                String[] xyTuple = key.split(",");
                String let = xyTuple[0];
                int w = Integer.parseInt(xyTuple[1]);
                int h = Integer.parseInt(xyTuple[2]);
                cm.get_curr_maze().changeBlock(w, h, let);
                System.out.println("Successfully added. You may keep adding or go back.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect command, please try again.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect command, please try again.");
            }
        }
    }
}
