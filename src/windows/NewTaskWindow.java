package windows;

import listeners.NewTaskSaveListener;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

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

        JLabel lbDeadline = new JLabel("Deadline: ");
        lbDeadline.setBounds(30,190,80,30);
        add(lbDeadline);

        JLabel lbDays = new JLabel("dias.");
        lbDays.setBounds(280,196,30,30);
        add(lbDays);

    }

    public void textFieldsAdd(){
        tfTitle = new JTextField();

        tfTitle.setBounds(100,100,250, 30);
        tfTitle.setFont(new Font("Arial", Font.ITALIC, 13));
        add(tfTitle);

        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            JFormattedTextField tfDeadline = new JFormattedTextField(dataMask);
            tfDeadline.setHorizontalAlignment(JLabel.CENTER);
            tfDeadline.setBounds(100,190,100,30);

            add(tfDeadline);
        } catch (ParseException e) {}

        JTextField tfDays = new JTextField();
        tfDays.setEnabled(false);
        tfDays.setBounds(220,190,50,30);
        add(tfDays);

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



