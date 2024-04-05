package tree;

import javax.swing.*;
import java.util.Date;

public class TaskNode {
    private String title;
    private int priority;
    private String description;
    private Date deadline;
    TaskNode left, right;

    public TaskNode(String title, int priority, String description, Date deadline){
        this.title = title;
        this.priority = priority;
        this.description = description;
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

    public Date getDate() {
        return deadline;
    }

    public void setDate(Date deadline) {
        this.deadline = deadline;
    }
}