package events;

import ui.ListofMazes;
import ui.MazeMap;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeEvents {
    private Scanner keys;

    public MazeEvents() {
        this.keys = new Scanner(System.in);
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Runs the main events for the creation, edit, and deletion of mazes
    public void handle_key() {

        ListofMazes lom = new ListofMazes();
        Status st = new Status();

        main_menu();

        while (keys.hasNext()) {
            String key = keys.nextLine();

            if (st.get_status() == 0) {
                run_status_zero(key, lom, st);
            }

            else if(st.get_status() == 1) {
                run_status_one(key, lom, st);
            }
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom (in the future), st
    // EFFECTS: Runs the creation, access of a maze and termination of program
    public void run_status_zero(String key, ListofMazes lom, Status st) {
        try {
            int cmd = Integer.parseInt(key);
            switch (cmd) {
                case 1:
                    st.change_status(1);
                    maze_create_msg();
                    break;
                case 2:
                    if (lom.get_mazes() == 0)
                        System.out.println("No mazes available!");
                    else
                        // TODO: Complete the function
                        System.out.println("What maze do you want to open?");
                    break;
                case 3:
                    System.out.println("Closing...\nThank you for using maze simulator!");
                    keys.close();
                    System.exit(0);  // Required as keys.hasNextInt() throws IllegalException if scanner closes
                    break;
                default:
                    System.out.println("Incorrect command, please try again.");
            }
        }
        catch(Exception e) {
            System.out.println("Incorrect command, please try again.");
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Creates a maze with w,h dimensions, and must have values greater than 1
    public void run_status_one(String key, ListofMazes lom, Status st) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            main_menu();
        }
        else {
            // TODO: Move the function so that it has a helper function instead
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
                    main_menu();
                }
            }
            catch (Exception e) {
                System.out.println("Maze was unable to be created, please try again.");
            }
        }
    }

    private void main_menu() {
        System.out.println("----------------------------------------" +
                " Main Menu ----------------------------------------");
        System.out.println("Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to close the application.");
    }

    private void maze_create_msg() {
        System.out.println("--------------" +
                " Maze Creation --------------");
        System.out.println("Enter the dimensions of your maze by using: w,h");
    }
}
