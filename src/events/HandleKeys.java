package events;

import ui.ToDoList;

import java.util.Scanner;

public class HandleKeys {
    private static final Scanner scan = new Scanner(System.in);

    public static void handlekeys() {
        if (scan.hasNext()) {
            String option = scan.nextLine();
            findoptions(option);
        }
    }

    public static void findoptions(String option) {

    }
}
