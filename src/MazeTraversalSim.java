import events.MazeEvents;
import ui.ListofMazes;

public class MazeTraversalSim {
    private static void welcome_sign() {
        System.out.println("----------------------------------------" +
                " Main Menu ----------------------------------------");
    }

    private static void generate_options() {
        System.out.println("Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to close the application.");
    }

    public static void main(String[] args) {
        MazeEvents me = new MazeEvents();

        welcome_sign();
        generate_options();
        me.handle_key();

    }
}
