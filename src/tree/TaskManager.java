package tree;

import javax.xml.crypto.Data;
import java.util.Date;

public class TaskManager {
    private TaskNode root;
    
    public TaskManager(){
        root = null;
    }

    public void addTask(String title, int priority, String description, String type, Data deadline){
        root = insert(root, title, priority, description, type, deadline);
    }

    private TaskNode insert(TaskNode root, String title, int priority, String description, String type, Data deadline){
        if (root == null){
            root = new TaskNode(title, priority, description, type, (Date) deadline);
            return root;
        }

        if(priority < root.getPriority()){
            root.left = insert(root.left, title, priority, description, type, deadline);
        }else if(priority > root.getPriority()){
            root.right =  insert(root.right, title, priority, description, type, deadline);
        } return root;
    }

    private void inorderTraversal(TaskNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println("Task: " + root.getTitle() + ", Priority: " + root.getPriority() +
                    ", Description: " + root.getDescription() + ", Date: " + root.getDeadline() +
                    ", Type: " + root.getType());
            inorderTraversal(root.right);
        }
    }

    public void printTasksInPriorityOrder() {
        System.out.println("Tasks in Priority Order:");
        inorderTraversal(root);
    }

}
