package ui;

public class Task {
    private String taskDesc;
    private String taskDue;
    private String taskCategory;

    Task(String desc, String date, String category) {
        this.taskDesc = desc;
        this.taskDue = date;
        this.taskCategory = category;
    }

    public String get_task() {
        return taskDesc;
    }

    public String get_due_date() {
        return taskDue;
    }

    public String get_task_category() {
        return taskCategory;
    }

    public void change_date(String date) {
        taskDue = date;
    }
}
