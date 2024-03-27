package tree;

import java.util.Date;

public class TaskNode {
    private String title;
    private int priority;
    private String description;
    private String type;
    private Date deadline;
    TaskNode left, right;

    public TaskNode(String title, int priority, String description, String type, Date deadline){
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.type = type;
        this.deadline = deadline;
        left = null;
        right = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
