package Forms;

import Controller.Forms.Stock.Cls_readStock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_Stock {
    public JPanel stock_JPanel;
    public JButton deleteItem_Button;
    public JButton newItem_button;
    public JButton editItem_button;
    public JPanel tablePanel;
    //public JScrollPane scrollPane;

    public Frm_Stock() {

        Cls_readStock readStock = new Cls_readStock();
        readStock.readStock();
        readStock.createTable();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(readStock.scrollPane, BorderLayout.CENTER);

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
