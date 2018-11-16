package ui.statuses;

import model.ListOfMaze;
import ui.CurrentMaze;
import ui.input.Messages;

public class StatusTwo {
    private Messages messages;

    public StatusTwo() {
        this.messages = new Messages();
    }

    public void run_status_two(CurrentMaze cm, String key, ListOfMaze lom, CurrentStatus st) {
        if (key.equals("back")) {
            st.change_status(0);
            System.out.println("Going back to Main Menu...");
            messages.main_menu();
        }
        else {
            try {
                Integer num = Integer.parseInt(key);
                if (num > lom.get_num_mazes()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                else {
                    cm.set_curr_maze(lom.get_maze(num-1));
                    cm.set_curr_maze_num(num-1);
                    st.change_status(3);
                    System.out.println("You have selected maze " + num);
                    messages.maze_options_msg();
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
}
