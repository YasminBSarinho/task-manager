package windows;

import com.sun.source.tree.NewArrayTree;
import tree.TaskNode;
import tree.TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.awt.SystemColor.window;

public abstract class DefaultWindow extends JFrame {
    private JButton rightButton;
    private JButton leftButton;

    public DefaultWindow(String title){
        setTitle(title);
        setSize(650, 600); // Largura, altrua
        setLocationRelativeTo(null); // inicializa no centro
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // finazliza o programa quanfo fecha a janela
        //getContentPane().setBackground(Color.gray);
        setResizable(true); // nao permite redimencionar  580 108 580 4x108
        addButtons();
        addMenu();
    }

    private void addButtons(){
        rightButton = new JButton();
        rightButton.setBounds(412, 460, 128, 40);
        add(rightButton);

        leftButton = new JButton();
        leftButton.setBounds(88, 460, 128, 40);
        add(leftButton);

    }

    private class MenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent select) {

            String option = select.getActionCommand();

            dispose();
            switch(option){
                case "Listar":
                    List<TaskNode> tasks = TaskManager.getAllTasks();
                    ListItemsWindow listItemsWindow = new ListItemsWindow("Lista de Tarefas");
                    listItemsWindow.addTable(tasks);
                    listItemsWindow.setVisible(true);
                    break;
                case "Novo":
                    NewTaskWindow newTaskWindow = new NewTaskWindow();
                    newTaskWindow.setVisible(true);
                    break;
            }


        }
    }


    private void addMenu(){

        MenuListener menuListener = new MenuListener();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuOptions = new JMenu("Opções");
        menuBar.add(menuOptions);

        JMenuItem itemNew = new JMenuItem("Novo");
        itemNew.addActionListener(menuListener);
        menuOptions.add(itemNew);

        JMenuItem itemsList = new JMenuItem("Listar");
        itemsList.addActionListener(menuListener);
        menuOptions.add(itemsList);

    }

    public JButton getRightButton() {
        return rightButton;
    }

    public void setRightButton(JButton rightButton) {
        this.rightButton = rightButton;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public void setLeftButton(JButton leftButton) {
        this.leftButton = leftButton;
    }
}
