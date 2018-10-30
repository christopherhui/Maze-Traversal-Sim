package ui;

import model.MazeMap;
import model.RectangularMazes;

import java.util.Map;

public class Messages {

    public void main_menu() {
        System.out.println("----------------------------------------" +
                " Main Menu ----------------------------------------");
        System.out.println("Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to close the application.");
    }

    public void maze_create_msg() {
        System.out.println("--------------" +
                " Maze Creation --------------");
        System.out.println("Enter the dimensions of your maze by using: w,h");
    }

    public void maze_options_msg() {
        System.out.println("---------------------------------------- Maze Editor " +
                "----------------------------------------");
        System.out.println("Press 1 to view selected maze. Press 2 to edit the maze. Press 3 to delete the maze.");
    }

    public void maze_edit_msg() {
        System.out.println("Valid characters: O- Empty, W- Wall, S- Start, E- End");
        System.out.println("Change your maze dimensions using: Character,h,w");
    }

    public void num_mazes_avail(RectangularMazes lom) {
        for (Map.Entry<Integer, MazeMap> entry : lom.get_mazes().entrySet()) {
            System.out.print(entry.getKey()+1 + ": " + entry.getValue().get_h() + " x " + entry.getValue().get_w() + " matrix" + " ");
        }
    }
}
