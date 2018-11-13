package ui;

import model.MazeMap;
import model.RectangularMazes;

import java.util.Map;

public class Messages {
    private final String LINES = "----------------------------------------";

    public void main_menu() {
        System.out.println(LINES +
                " Main Menu " + LINES);
        System.out.println("Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to close the application.");
    }

    public void maze_create_msg() {
        System.out.println(LINES +
                " Maze Creation " + LINES);
        System.out.println("Enter the dimensions of your maze by using: w,h");
    }

    public void maze_options_msg() {
        System.out.println(LINES + " Maze Editor " + LINES);
        System.out.println("Press 1 to view selected maze. Press 2 to edit the maze. Press 3 to delete the maze.");
    }

    public void maze_edit_msg() {
        System.out.println("Valid characters: O- Empty, W- Wall, S- Start, E- End");
        System.out.println("Change your maze dimensions using: Character,h,w");
    }

    public void num_mazes_avail(RectangularMazes lom) {
        int i = 1;
        for (MazeMap mazeMap : lom.get_mazes()) {
            System.out.print(i + ": " + mazeMap.get_h() + " x " + mazeMap.get_w() + " matrix" + " ");
            i++;
        }
    }
}
