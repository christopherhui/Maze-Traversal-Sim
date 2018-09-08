package ui;

import java.util.*;

public class ToDoList {
    public void welcomeSign() {
        System.out.println("Welcome to your todo list.\nOptions: Press 1 to find your tasks, " +
                "Press 2 to add a task. " + "Press 3 to remove a task.");
    }

    public void generateOptions() {
    }

    public static void main(String[] args) {
        Scanner options = new Scanner(System.in);

        ToDoList tdl = new ToDoList();
        tdl.welcomeSign();

        options.close();
    }
}
