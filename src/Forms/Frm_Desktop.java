package Forms;

import Controller.Forms.Stock.Cls_readStock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_Desktop extends JPanel {
    public JPanel desktop_JPanel;
    private JButton stockButton;
    private JButton customerButton;
    private JButton billButton;
    private JButton exitButton;
    private JPanel screen;


    public Frm_Desktop() {

     Frm_Stock   frmStock = new Frm_Stock();

   stockButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Botón de stock presionado.");
            if (frmStock != null && frmStock.stock_JPanel != null) {
                screen.setLayout(new GridLayout(1,1));
                screen.removeAll();
                screen.add(frmStock.stock_JPanel);
                screen.revalidate();
                screen.repaint();
                Cls_readStock read = new Cls_readStock();
                read.readStock();
            }
        }



    });
    customerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    billButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
