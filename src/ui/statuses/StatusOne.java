package ui.statuses;

import model.ListOfMaze;
import model.MazeMap;
import ui.input.Messages;

public class StatusOne {
    private Messages messages;

    public StatusOne() {
        this.messages = new Messages();
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Creates a maze with w,h dimensions, and must have values greater than 1
    public void run_status_one(String key, ListOfMaze lom, CurrentStatus st) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            messages.main_menu();
        }
        else {
            try {
                String[] xyTuple = key.split(",");
                int w = Integer.parseInt(xyTuple[0]);
                int h = Integer.parseInt(xyTuple[1]);
                if (w <= 1 || h <= 1) {
                    System.out.println("Maze dimensions are smaller than 2, please try again.");
                }
                else {
                    MazeMap maze = new MazeMap(w, h);
                    System.out.println("Maze successfully created.\n");
                    lom.add_maze(maze);
                    st.change_status(0);
                    messages.main_menu();
                }
            }
            catch (Exception e) {
                System.out.println("Maze was unable to be created, please try again.");
            }
        }
    }
}
