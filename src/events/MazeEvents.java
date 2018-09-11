package events;

import ui.MazeMap;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeEvents {

    public void handle_key() {
        Scanner keys = new Scanner(System.in);
        while (keys.hasNextInt()) {
            int key = keys.nextInt();
            if (false) {
                switch (key) {
                    case 1:
                        System.out.println("What are the dimensions of your maze?");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

}
