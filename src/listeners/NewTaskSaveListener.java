package listeners;

import tree.TaskManager;
import tree.TaskNode;
import windows.NewTaskWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTaskSaveListener implements ActionListener {

    private NewTaskWindow window;


    public NewTaskSaveListener(NewTaskWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String title = window.getTfTitle();
        JOptionPane.showMessageDialog(window, "Clicou, tarefa: " + title);
        var task = TaskManager.getInstance();
        task.addTask(window.getTfTitle(), window.getPriority(), window.getTfDescription(), window.getDate());
        task.printTasksInPriorityOrder();

        NewTaskWindow newTaskWindow = new NewTaskWindow();
        newTaskWindow.setVisible(true);

        window.dispose();
    }
}
