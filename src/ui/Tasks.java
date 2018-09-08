package ui;
import java.util.*;

public class Tasks {
    private int numTasks;
    private Vector<String> tasks;

    public int getTasks() {
        return numTasks;
    }

    public void addTask(String str) {
        tasks.add(str);
        numTasks += 1;
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(Integer.toString(i-1) + ": " + tasks.get(i));
        }
    }
}
