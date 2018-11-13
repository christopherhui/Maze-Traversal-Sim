package ui.statuses;

import model.MazeMap;
import model.RectangularMazes;
import ui.CurrentMaze;
import ui.Messages;

public class StatusThree {
    private Messages messages;

    public StatusThree() {
        this.messages = new Messages();
    }

    public void run_status_three(CurrentMaze cm, String key, RectangularMazes lom, CurrentStatus st) {
        if (key.equals("back")) {
            st.change_status(0);
            lom.replace_maze(cm.get_curr_maze_num(), cm.get_curr_maze());
            System.out.println("Going back to Main Menu...");
            messages.main_menu();
        }
        else {
            try {
                int cmd = Integer.parseInt(key);
                switch (cmd) {
                    case 1:
                        System.out.println("Your maze looks like this: ");
                        System.out.println(cm.get_curr_maze());
                        messages.maze_options_msg();
                        break;
                    case 2:
                        messages.maze_edit_msg();
                        st.change_status(4);
                        break;
                    case 3:
                        lom.remove_maze(cm.get_curr_maze_num());
                        System.out.println("Maze deleted.");
                        st.change_status(0);
                        messages.main_menu();
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
