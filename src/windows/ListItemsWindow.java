package windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListItemsWindow extends DefaultWindow {

    public ListItemsWindow(String title) {
        super(title);
        addTable();
        setVisible(true);
    }

    private void addTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Prioridade");
        model.addColumn("Título");
        model.addColumn("Data");
        model.addColumn("Descrição");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void showWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ListItemsWindow listItemsWindow = new ListItemsWindow("Lista de Tarefas");
            }
        });
    }
}
