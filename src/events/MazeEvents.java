package events;

import ui.MazeMap;

import java.util.ArrayList;
import java.util.Scanner;

// todo: Can we parse without using a try/catch block?
public class MazeEvents {

    public void handle_key() {
        Scanner keys = new Scanner(System.in);
        Status st = new Status();

        while (keys.hasNext()) {
            String key = keys.next();
            if (st.get_status()) {
                try {
                    int cmd = Integer.parseInt(key);
                    switch (cmd) {
                        case 1:
                            System.out.println("What are the dimensions of your maze?");
                            break;
                        case 2:
                            System.out.println("lol");
                            break;
                        case 3:
                            System.out.println("ok");
                            break;
                        case 4:
                            System.out.println("Closing...\nThank you for playing!");
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
        }
    }
}
