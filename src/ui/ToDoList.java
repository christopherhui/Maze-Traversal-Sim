package ui;

import java.util.*;

public class ToDoList {
    public void welcomeSign() {
        System.out.println("Welcome to your todo list.");
    }

    public void generateOptions() {
        System.out.println("Options: Press 1 to find your tasks, " +
        "Press 2 to add a task. " + "Press 3 to remove a task.");
    }
    public void handleKeys() {
    }

    public static void main(String[] args) {
        Scanner options = new Scanner(System.in);

        ToDoList tdl = new ToDoList();
        tdl.welcomeSign();
        tdl.generateOptions();

        options.close();
    }
}
