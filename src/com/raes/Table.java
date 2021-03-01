package com.raes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame{
    private JPanel panel1;
    private JScrollPane table1;
    public Table(Queue queue){
        setBounds(0,0,600,400);
        add(panel1);
        loadTable(queue);
    }

    private void loadTable(Queue queue){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Source");
        model.addColumn("Target");
        model.addColumn("Value");
        model.addColumn("Updated");
        for (Object exChange : queue.values()){
            ExChange current = ((ExChange) exChange);
            if (current != null){
                model.addRow(new Object[]{current.source,current.target,current.value,current.updated});
            }
        }
        JTable table = new JTable();
        table.setModel(model);
        table1.getViewport ().add (table);
    }
}
