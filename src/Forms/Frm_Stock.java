package Forms;

import Controller.Forms.Stock.Cls_deleteStock;
import Controller.Forms.Stock.Cls_readStock;
import Controller.Forms.Stock.Cls_search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frm_Stock {
    public JPanel stock_JPanel;
    public JButton deleteItem_Button;
    public JButton newItem_button;
    public JButton editItem_button;
    public JPanel tablePanel;
    public  JTextField searchField;
    public JButton searchButton;


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


        deleteItem_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cls_deleteStock delete = new Cls_deleteStock();
delete.deleteItem();
            }
        });
        editItem_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cls_search search = new Cls_search();
                search.searchItem(searchField);

            }
        });

        searchField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });


    }
}
