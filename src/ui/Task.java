package ui;

public class Task {
    String taskDesc;
    String taskDue;
    String taskCategory;

    Task(String desc, String date, String category) {
        this.taskDesc = desc;
        this.taskDue = date;
        this.taskCategory = category;
    }
}
