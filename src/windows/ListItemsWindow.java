package windows;

import tree.TaskManager;
import tree.TaskNode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;

public class ListItemsWindow extends DefaultWindow {

    private DefaultTableModel model;

    public ListItemsWindow(String title) {
        super(title);
        model = new DefaultTableModel();
        model.addColumn("Prioridade");
        model.addColumn("Título");
        model.addColumn("Data");
        model.addColumn("Descrição");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 50, 500, 300);
        add(scrollPane);

        setVisible(true);
    }

}
