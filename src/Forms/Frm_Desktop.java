package Forms;

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
    private Frm_Stock frmStock;

    public Frm_Desktop() {

        frmStock = new Frm_Stock();
   stockButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Botón de stock presionado.");
            if (frmStock != null && frmStock.stock_JPanel != null) {
                screen.setLayout(new GridLayout(1,1));
                // Remueve cualquier otro componente que esté en el JPanel screen
                screen.removeAll();
                // Agrega el stock_JPanel al JPanel screen
                screen.add(frmStock.stock_JPanel);
                // Refresca el JPanel para que se muestre el stock_JPanel
                screen.revalidate();
                screen.repaint();
            }
//            screen.add(frmStock.stock_JPanel);
//            screen.revalidate();
//            screen.repaint();
//            JFrame stockFrame = new JFrame("pantalla de stock");
//            stockFrame.setContentPane(frmStock.stock_JPanel);
//            stockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            stockFrame.setSize(1200,700);
//            stockFrame.setLocationRelativeTo(null);
//            stockFrame.setVisible(true);
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
