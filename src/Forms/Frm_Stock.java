package Forms;

import Controller.Forms.Stock.Cls_readStock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Frm_Stock {
    public JPanel stock_JPanel;

    public JButton deleteItem_Button;
    public JButton newItem_button;
    public JButton editItem_button;
    public JScrollPane scrollTable;


    public Frm_Stock() {
        Cls_readStock readStock = new Cls_readStock();

        String[] columnNames = {"Ref", "Nombre", "PVP", "Neto", "Unidades"};
        Object[][] data = {
                {readStock.ref, readStock.name, readStock.pvp,readStock.neto, readStock.units},
                {"002", "Producto 2", 15.0, 12.5, 50},

        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(tableModel);
        scrollTable = new JScrollPane(table);






        newItem_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frm_InsertItem frmInsertItem = new Frm_InsertItem();
                JFrame insertItemFrame = new JFrame("Añadir producto");
                insertItemFrame.setContentPane(frmInsertItem.insertItem);
                insertItemFrame.setSize(850, 150);
                insertItemFrame.setLocationRelativeTo(null);
                insertItemFrame.setVisible(true);
            }
        });
    }



}
