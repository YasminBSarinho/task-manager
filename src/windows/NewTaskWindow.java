package windows;

import listeners.NewTaskSaveListener;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTaskWindow extends DefaultWindow{
    private JTextField tfTitle;
    private JTextArea tfDescription;
    private JFormattedTextField tfDeadline;
    private JComboBox<String> cbPriority;
    private JComboBox<String> cbTipe;


    public NewTaskWindow(){
        super("Criar nova tarefa"); // Titulo
        addTitle();
        addLabel();
        textFieldsAdd();
        selectPriority();
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

        JLabel lbDescription = new JLabel("Descricao: ");
        lbDescription.setBounds(30,155,80,30);
        add(lbDescription);

        JLabel lbDeadline = new JLabel("Deadline: ");
        lbDeadline.setBounds(30,240,80,30);
        add(lbDeadline);

        JLabel lbDays = new JLabel("dias.");
        lbDays.setBounds(280,246,30,30);
        add(lbDays);

        JLabel lbTipePriority = new JLabel("Prioridade: ");
        lbTipePriority.setBounds(30,300,80,30);
        add(lbTipePriority);

        JLabel lbTipe = new JLabel("Tipo: ");
        lbTipe.setBounds(30,360,80,30);
        add(lbTipe);

    }

    public void textFieldsAdd() {
        tfTitle = new JTextField();

        tfTitle.setBounds(100, 100, 250, 30);
        tfTitle.setFont(new Font("Arial", Font.ITALIC, 13));
        add(tfTitle);


        tfDescription = new JTextArea();
        JScrollPane pane = new JScrollPane(tfDescription);
        pane.setBounds(100,155, 340, 65);
        tfDescription.setLineWrap(true);
        tfDescription.setWrapStyleWord(true);
        add(pane);

        JFormattedTextField tfDeadline = null;
        try {
            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            tfDeadline = new JFormattedTextField(dataMask);
            tfDeadline.setHorizontalAlignment(JLabel.CENTER);
            tfDeadline.setBounds(100, 240, 100, 30);

            add(tfDeadline);
        } catch (ParseException e) {}

        JFormattedTextField finalTfDeadline = tfDeadline;
        tfDeadline.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String actualValue = finalTfDeadline.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date validDate = sdf.parse(actualValue);
                } catch (ParseException ex) {}

            }

            @Override
            public void focusGained(FocusEvent e) {


            }

        });

        JTextField tfDays = new JTextField();
        tfDays.setEnabled(false);
        tfDays.setBounds(220, 240, 50, 30);
        add(tfDays);

    }

    public void selectPriority(){
        String[] listPriority = new String[4];
        listPriority = new String[]{"Normal", "Baixa", "Media", "Alta"};
        cbPriority = new JComboBox<String>(listPriority);
        cbPriority.setBounds(100,300,80,30);
        add(cbPriority);


        String[] listTipe = new String[5];
        listTipe = new String[]{"Casa", "Faculdade", "Trabalho", "Financeiro", "Lazer"};
        cbTipe = new JComboBox<String>(listTipe);
        cbTipe.setBounds(100,360,80,30);
        add(cbTipe);

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

    public JTextArea getTfDescription(){
        return tfDescription;
    }

    public JFormattedTextField getTfDeadline(){
        return tfDeadline;
    }

    public JComboBox<String> getCbPriority(){
        return cbPriority;
    }

    public JComboBox<String> getCbTipe(){
        return cbTipe;
    }
}



