package listeners;

import windows.NewTaskWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTaskSaveListener implements ActionListener {

    private NewTaskWindow window;

    public NewTaskSaveListener(NewTaskWindow window){
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String title = window.getTfTitle().getText();
        JOptionPane.showMessageDialog(window, "Clicou, tarefa: " + title);
    }
}
