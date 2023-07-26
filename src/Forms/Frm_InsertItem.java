package Forms;

import Class.Forms.Stock.Cls_saveStock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_InsertItem extends JFrame {
    public JButton add_Button;
    public JPanel insertItem;
    public JTextField neto_TextField;
    public JTextField PVP_TextField;
    public JTextField name_TextField;
    public JTextField ref_TextField;
    public JTextField units_TextField;
    public JLabel Ref;
    public JLabel Name;
    public JLabel PVP;
    public JLabel Units;

    public Frm_InsertItem() {
        add_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cls_saveStock save = new Cls_saveStock();
                save.saveData(ref_TextField,name_TextField,PVP_TextField,neto_TextField,units_TextField);

            }
        });
    }


}
