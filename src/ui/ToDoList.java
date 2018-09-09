package ui;

import java.util.*;

public class ToDoList {
    private static void welcomeSign() {
        System.out.println("Welcome to your todo list.");
    }

    private static void generateOptions() {
        System.out.println("Options: Press 1 to find your tasks, " +
        "Press 2 to add a task. " + "Press 3 to remove a task.");
    }
    private static void handleKeys() {
        System.out.println("--- Handles Keys ---");
    }

    public static void main(String[] args) {
        Scanner options = new Scanner(System.in);

        welcomeSign();
        generateOptions();
        handleKeys();

        options.close();
    }
}
