package tree;

import javax.swing.*;
import java.util.Date;

public class TaskManager {
    private TaskNode root;
    
    public TaskManager(){
        root = null;
    }

    public void addTask(String title, int priority, String description, Date deadline){
        root = insert(root, title, priority, description, deadline);
    }

    private TaskNode insert(TaskNode root, String title, int priority, String description, Date deadline){
        if (root == null){
            root = new TaskNode(title, priority, description, deadline);
            return root;
        }

        if(priority < root.getPriority()){
            root.left = insert(root.left, title, priority, description, deadline);
        }else if(priority > root.getPriority()){
            root.right =  insert(root.right, title, priority, description, deadline);
        } return root;
    }

    private void inorderTraversal(TaskNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println("Task: " + root.getTitle() + ", Priority: " + root.getPriority() +
                    ", Description: " + root.getDescription() + ", Date: " + root.getDate());
            inorderTraversal(root.right);
        }
    }

    public void printTasksInPriorityOrder() {
        System.out.println("Tasks in Priority Order:");
        inorderTraversal(root);
    }

}
