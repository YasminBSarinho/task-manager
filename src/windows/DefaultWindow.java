package windows;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    new ListItemsWindow("Lista");
                    break;
                case "Novo":
                    new NewTaskWindow();
                    break;
                case "Sair":
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

        JMenuItem itemExit = new JMenuItem("Sair");
        menuOptions.add(itemExit);

        JMenu itemsList = new JMenu("Listar");
        menuBar.add(itemsList);

        JMenuItem listPriority = new JMenuItem("Listar por prioridade");
        itemsList.add(listPriority);

        JMenuItem listDay = new JMenuItem("Listar por dia");
        itemsList.add(listDay);

        JMenuItem listMonth = new JMenuItem("Listar por mes");
        itemsList.add(listMonth);

        JMenuItem listYear = new JMenuItem("Listar por ano");
        itemsList.add(listYear);

        JMenuItem listCompleted = new JMenuItem("Listar conculidas");
        itemsList.add(listCompleted);

        JMenuItem listOrder = new JMenuItem("Listar tarefas por ordem");
        itemsList.add(listCompleted);

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
