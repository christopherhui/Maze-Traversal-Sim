package ui;
import java.util.Vector;

public class ListofTasks {
    private int numTasks;
    private Vector<Task> tasks;

    public int getTasks() {
        return numTasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        numTasks += 1;
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(Integer.toString(i-1) + ": " + tasks.get(i));
        }
    }
}
