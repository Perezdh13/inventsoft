package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_Stock{
    public JPanel stock_JPanel;
    public JTable stockTable;
    public JButton deleteItem_Button;
    public JButton newItem_button;
    public JButton editItem_button;


    public Frm_Stock(){

        newItem_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frm_InsertItem frmInsertItem = new Frm_InsertItem();
                JFrame insertItemFrame = new JFrame("Añadir Item");
                insertItemFrame.setContentPane(frmInsertItem.insertItem);
                insertItemFrame.setSize(850,150);
                insertItemFrame.setLocationRelativeTo(null);
                insertItemFrame.setVisible(true);
            }
        });
    }


}
