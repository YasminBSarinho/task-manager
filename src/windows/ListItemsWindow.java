package windows;

import tree.TaskManager;
import tree.TaskNode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListItemsWindow extends DefaultWindow {

    public ListItemsWindow(String title) {
        super(title);
        addTable();
        setVisible(true);
    }

    void addTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Prioridade");
        model.addColumn("Título");
        model.addColumn("Data");
        model.addColumn("Descrição");

        for (TaskNode task : tasks) {
            model.addRow(new Object[]{task.getPriority(), task.getTitle(), task.getDate(), task.getDescription()});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 50, 500, 300);
        add(scrollPane);
    }


}
