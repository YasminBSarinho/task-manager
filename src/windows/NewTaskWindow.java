package windows;

import listeners.NewTaskSaveListener;

import javax.swing.*;
import java.awt.*;

public class NewTaskWindow extends DefaultWindow{
    private JTextField tfTitle;

    public NewTaskWindow(){
        super("Criar nova tarefa"); // Titulo
        addTitle();
        addLabel();
        textFieldsAdd();
        setVisible(true); // torna a tela visivel
        buttonsConfig();
    }

    private void addTitle(){
        JLabel lbTitle = new JLabel("To-Do List");
        lbTitle.setBounds(0, 20, 620, 30);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        add(lbTitle);
    }

    public void addLabel(){
        JLabel lbTitle = new JLabel(("Titulo: "));
        lbTitle.setBounds(30,100,80,30);
        add(lbTitle);
    }

    public void textFieldsAdd(){
        tfTitle = new JTextField();

        tfTitle.setBounds(80,100,250, 30);
        tfTitle.setFont(new Font("Courier New", Font.ITALIC, 13));
        add(tfTitle);
    }

    private void buttonsConfig(){

        JButton leftButton = getLeftButton();
        JButton rightButton = getRightButton();

        NewTaskSaveListener listener = new NewTaskSaveListener(this);
        leftButton.addActionListener(listener);

        getLeftButton().setText("Salvar");
        getRightButton().setText("Limpar");
    }

    public JTextField getTfTitle() {
        return tfTitle;
    }
}



