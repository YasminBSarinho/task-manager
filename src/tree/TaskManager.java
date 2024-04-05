package tree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private static TaskManager instancia;
    private static TaskNode root;

    private TaskManager() {}

    public static TaskManager getInstance() {
        if(instancia == null) {
            root = null;
            return instancia = new TaskManager();
        }
        return instancia;
    }

    public void addTask(String title, int priority, String description, Date deadline) {
        root = insert(root, title, priority, description, deadline);
    }

    private TaskNode insert(TaskNode root, String title, int priority, String description, Date deadline) {
        if (root == null) {
            root = new TaskNode(title, priority, description, deadline);
            return root;
        }

        if (priority < root.getPriority()) {
            root.left = insert(root.left, title, priority, description, deadline);
        } else if (priority > root.getPriority()) {
            root.right = insert(root.right, title, priority, description, deadline);
        } else {
            // Tratar casos de prioridades iguais conforme necessÃ¡rio
            root.right = insert(root.right, title, priority, description, deadline);
        }

        return root;
    }


    private void reverseInorderTraversal(TaskNode root) {
        if (root != null) {
            reverseInorderTraversal(root.right);
            System.out.println("Task: " + root.getTitle() + ", Priority: " + root.getPriority() +
                    ", Description: " + root.getDescription() + ", Date: " + root.getDate());
            reverseInorderTraversal(root.left);
        }
    }

    public void printTasksInPriorityOrder() {
        System.out.println("Tasks in Priority Order (from highest to lowest):");
        reverseInorderTraversal(root);
    }

    public static List<TaskNode> getAllTasks() {
        List<TaskNode> allTasks = new ArrayList<>();
        inOrderTraversal(root, allTasks);
        System.out.println("Total tasks found: " + allTasks.size());
        return allTasks;
    }



    private static void inOrderTraversal(TaskNode node, List<TaskNode> list) {
        if (node != null) {
            System.out.println("Visiting node: " + node.getTitle());
            inOrderTraversal(node.left, list);
            list.add(node);
            inOrderTraversal(node.right, list);
        }
    }


}
