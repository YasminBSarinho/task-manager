package windows;

import listeners.NewTaskSaveListener;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTaskWindow extends DefaultWindow {
    private JTextField tfTitle;
    private JTextArea tfDescription;
    private JFormattedTextField tfDeadline;
    private JComboBox<String> cbPriority;
    private JComboBox<String> cbTipe;
    private int selectedPriority = 1;
    private Date validDate;

    public NewTaskWindow() {
        super("Criar nova tarefa");
        addTitle();
        addLabel();
        textFieldsAdd();
        selectPriority();
        setVisible(true);
        buttonsConfig();


        tfDeadline.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String actualValue = tfDeadline.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date validDate = sdf.parse(actualValue);
                } catch (ParseException ignored) {

                }
            }

            @Override
            public void focusGained(FocusEvent e) {}
        });
    }

    private void addTitle() {
        JLabel lbTitle = new JLabel("To-Do List");
        lbTitle.setBounds(0, 20, 620, 30);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        add(lbTitle);
    }

    public void addLabel() {
        JLabel lbTitle = new JLabel(("Titulo: "));
        lbTitle.setBounds(30, 100, 80, 30);
        add(lbTitle);

        JLabel lbDescription = new JLabel("Descricao: ");
        lbDescription.setBounds(30, 155, 80, 30);
        add(lbDescription);

        JLabel lbDeadline = new JLabel("Deadline: ");
        lbDeadline.setBounds(30, 240, 80, 30);
        add(lbDeadline);

        JLabel lbTipePriority = new JLabel("Prioridade: ");
        lbTipePriority.setBounds(30, 300, 80, 30);
        add(lbTipePriority);

    }

    public void textFieldsAdd() {
        tfTitle = new JTextField();
        tfTitle.setBounds(100, 100, 250, 30);
        tfTitle.setFont(new Font("Arial", Font.ITALIC, 13));
        add(tfTitle);

        tfDescription = new JTextArea();
        JScrollPane pane = new JScrollPane(tfDescription);
        pane.setBounds(100, 155, 340, 65);
        tfDescription.setLineWrap(true);
        tfDescription.setWrapStyleWord(true);
        add(pane);

        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            tfDeadline = new JFormattedTextField(dataMask);
            tfDeadline.setHorizontalAlignment(JLabel.CENTER);
            tfDeadline.setBounds(100, 240, 100, 30);
            add(tfDeadline);
        } catch (ParseException ignored) {}

        tfDeadline.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String actualValue = tfDeadline.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date validDate = sdf.parse(actualValue);
                } catch (ParseException ignored) {}
            }

            @Override
            public void focusGained(FocusEvent e) {}
        });
    }

    public void selectPriority() {
        String[] listPriority = new String[]{"Normal", "Baixa", "Media", "Alta"};
        cbPriority = new JComboBox<>(listPriority);
        cbPriority.setBounds(100, 300, 80, 30);
        add(cbPriority);

        cbPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPriority = cbPriority.getSelectedIndex() + 1;
            }
        });
    }

    private void buttonsConfig(){
        JButton leftButton = getLeftButton();
        JButton rightButton = getRightButton();
        NewTaskSaveListener listener = new NewTaskSaveListener(this);
        leftButton.addActionListener(listener);

        getLeftButton().setText("Salvar");
        getRightButton().setText("Limpar");
    }


    public String getTfTitle() {
        return tfTitle.getText();
    }

    public int getPriority(){
        return selectedPriority;
    }

    public String getTfDescription() {
        return tfDescription.getText();
    }

    public Date getDate() {
        return validDate;
    }

}
