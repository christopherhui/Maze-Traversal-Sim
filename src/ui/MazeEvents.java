package ui;

import exceptions.IllegalCharacterException;
import model.RectangularMazes;
import model.MazeMap;
import model.Status;

import java.util.Map;
import java.util.Scanner;

public class MazeEvents {
    private Scanner keys;
    private MazeMap currMaze;
    private int currMazeNum;

    public MazeEvents() {
        this.keys = new Scanner(System.in);
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Runs the main model for the creation, edit, and deletion of mazes
    public void handle_key() {

        RectangularMazes lom = new RectangularMazes();
        Status st = new Status();

        main_menu();

        // Zero: Main menu of program
        // One: Runs the creation of maze using dimensions
        // Two: Accesses a certain maze created previously
        // Three: Does things to selected maze
        while (keys.hasNext()) {
            String key = keys.nextLine();

            if (st.get_status() == 0) {
                run_status_zero(key, lom, st);
            }

            else if(st.get_status() == 1) {
                run_status_one(key, lom, st);
            }
            else if(st.get_status() == 2) {
                run_status_two(key, lom, st);
            }
            else if(st.get_status() == 3) {
                run_status_three(key, lom, st);
            }
            else if(st.get_status() == 4) {
                try {
                    run_status_four(key, st);
                } catch (IllegalCharacterException e) {
                    System.out.println("Incorrect character found, please try again.");
                }
            }
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom (in the future), st
    // EFFECTS: Runs the creation, access of a maze and termination of program
    public void run_status_zero(String key, RectangularMazes lom, Status st) {
        try {
            int cmd = Integer.parseInt(key);
            switch (cmd) {
                case 1:
                    st.change_status(1);
                    maze_create_msg();
                    break;
                case 2:
                    if (lom.get_num_mazes() == 0)
                        System.out.println("No mazes available!");
                    else {
                        System.out.println("What maze do you want to open?");
                        num_mazes_avail(lom);
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
        }
        catch(Exception e) {
            System.out.println("Incorrect command, please try again.");
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Creates a maze with w,h dimensions, and must have values greater than 1
    public void run_status_one(String key, RectangularMazes lom, Status st) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            main_menu();
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
                    main_menu();
                }
            }
            catch (Exception e) {
                System.out.println("Maze was unable to be created, please try again.");
            }
        }
    }

    public void run_status_two(String key, RectangularMazes lom, Status st) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            main_menu();
        }
        else {
            try {
                Integer num = Integer.parseInt(key);
                if (num > lom.get_num_mazes()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                else {
                    set_curr_maze(lom.get_maze(num-1));
                    set_curr_maze_num(num-1);
                    st.change_status(3);
                    System.out.println("You have selected maze " + num);
                    maze_options_msg();
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Maze not found, please try again.");
            }
            catch (Exception e) {
                System.out.println("Incorrect command, please try again.");
            }
        }
    }

    public void run_status_three(String key, RectangularMazes lom, Status st) {
        if (key.equals("back")) {
            st.change_status(0);
            lom.replace_maze(get_curr_maze_num(), get_curr_maze());
            System.out.println("Going back to Main Menu...");
            main_menu();
        }
        else {
            try {
                int cmd = Integer.parseInt(key);
                switch (cmd) {
                    case 1:
                        System.out.println("Your maze looks like this: ");
                        System.out.println(get_curr_maze());
                        maze_options_msg();
                        break;
                    case 2:
                        maze_edit_msg();
                        st.change_status(4);
                        break;
                    case 3:
                        // TODO: Finish this method
                        break;
                    default:
                        System.out.println("Incorrect command, please try again.");
                }
            }
            catch(Exception e) {
                System.out.println("Incorrect command, please try again.");
            }
        }
    }

    public void run_status_four(String key, Status st) throws IllegalCharacterException {
        if (key.equals("back")) {
            st.change_status(3);
            System.out.println("Going back to Maze...");
            maze_options_msg();
        }
        else {
            try {
                String[] xyTuple = key.split(",");
                String let = xyTuple[0];
                int w = Integer.parseInt(xyTuple[1]);
                int h = Integer.parseInt(xyTuple[2]);
                currMaze.changeBlock(w, h, let);
                System.out.println("Successfully added. You may keep adding or go back.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect command, please try again.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect command, please try again.");
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

    private void maze_options_msg() {
        System.out.println("---------------------------------------- Maze Editor " +
                "----------------------------------------");
        System.out.println("Press 1 to view selected maze. Press 2 to edit the maze. Press 3 to delete the maze.");
    }

    private void maze_edit_msg() {
        System.out.println("Valid characters: O- Empty, W- Wall, S- Start, E- End");
        System.out.println("Change your maze dimensions using: Character,w,h");
    }

    private void num_mazes_avail(RectangularMazes lom) {
        for (Map.Entry<Integer, MazeMap> entry : lom.get_mazes().entrySet()) {
            System.out.print(entry.getKey()+1 + ": " + entry.getValue().get_h() + " x " + entry.getValue().get_w() + " matrix" + " ");
        }
    }

    public int get_curr_maze_num() {
        return currMazeNum;
    }

    public void set_curr_maze_num(int i) {
        currMazeNum = i;
    }

    public MazeMap get_curr_maze() {
        return currMaze;
    }

    private void set_curr_maze(MazeMap m) {
        currMaze = m;
    }
}
