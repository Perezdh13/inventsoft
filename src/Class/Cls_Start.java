package Class;

import Database.Cls_Credentials;
import Forms.Frm_Desktop;
import Forms.Frm_Login;
import Forms.Frm_Stock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cls_Start {
    public static void start() {
        Frm_Login loginForm = new Frm_Login();
        Frm_Stock stockForm = new Frm_Stock();
        Frm_Desktop desktopForm = new Frm_Desktop();
        Cls_Credentials clsCredentials = new Cls_Credentials();

        if (clsCredentials.isPass() == false) {
            JFrame loginFrame = new JFrame("formulario inicio de sesion");
            loginFrame.setContentPane(loginForm.login_Panel);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(600, 600);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);

            loginForm.enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String user = loginForm.textField1.getText();
                    String password = loginForm.passwordField1.getText();

                    if (user.equals(clsCredentials.getUser()) && password.equals(clsCredentials.getPassword())) {
                        loginFrame.dispose(); //esto cierra loginFrame
                        JOptionPane.showMessageDialog(null, "Bienvenido " + user);
                        JFrame desktopFrame = new JFrame("Pantalla principal");
                        desktopFrame.setContentPane(desktopForm.desktop_JPanel);
                        desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        desktopFrame.setSize(1200, 700);
                        desktopFrame.setLocationRelativeTo(null);
                        desktopFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos.");
                        loginForm.textField1.setText("");
                        loginForm.passwordField1.setText("");
                    }
                }
            });
        }

    }
}
