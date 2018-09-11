import events.MazeEvents;
import ui.MazeMap;

public class MazeTraversalSim {
    private static void welcome_sign() {
        System.out.println("Welcome to your create a maze.");
    }

    private static void generate_options() {
        System.out.println("Options: Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to import a maze.");
    }

    public static void main(String[] args) {
        MazeEvents me = new MazeEvents();

        welcome_sign();
        generate_options();
        me.handle_key();

        MazeMap map1 = new MazeMap(5, 5);

    }
}
