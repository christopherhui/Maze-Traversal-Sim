package events;

import ui.ListofMazes;
import ui.MazeMap;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeEvents {
    Scanner keys;
    Status st;
    ListofMazes lom;

    public MazeEvents() {
        this.keys = new Scanner(System.in);
        this.st = new Status();
        this.lom = new ListofMazes();
        handle_key();
    }

    // REQUIRES: Is a String input
    // MODIFIES: this
    // EFFECTS: Runs the main events for the creation, edit, and deletion of mazes
    public void handle_key() {

        main_menu();

        while (keys.hasNext()) {
            String key = keys.nextLine();

            if (st.get_status() == 0) {
                run_status_zero(key);
            }

            else if(st.get_status() == 1) {
                run_status_one(key);
            }
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this
    // EFFECTS: Runs the creation, access of a maze and termination of program
    public void run_status_zero(String key) {
        try {
            int cmd = Integer.parseInt(key);
            switch (cmd) {
                case 1:
                    st.change_status(1);
                    maze_create();
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
    // MODIFIES: this
    // EFFECTS: Creates a maze with x,y dimensions, and must have values greater than 1
    public void run_status_one(String key) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            main_menu();
        }
        else {
            // TODO: Move the function so that it has a helper function instead
            try {
                String[] xyTuple = key.split(",");
                int x = Integer.parseInt(xyTuple[0]);
                int y = Integer.parseInt(xyTuple[1]);
                if (x <= 1 || y <= 1) {
                    System.out.println("Maze dimensions are smaller than 2, please try again.");
                }
                else {
                    MazeMap maze = new MazeMap(x, y);
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

    private void maze_create() {
        System.out.println("--------------" +
                " Maze Creation --------------");
        System.out.println("Enter the dimensions of your maze by using: x,y");
    }
}
