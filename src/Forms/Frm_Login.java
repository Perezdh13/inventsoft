package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_Login {
    public JButton enterButton;
    public JTextField textField1;
    public JPasswordField passwordField1;
    public JPanel login_Panel;



    public Frm_Login(){
        String user = "PEPE";
        String password = "1234";

        enterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userField = textField1.getText();
                String passwordField = passwordField1.getText();
                if(user.equals(userField) && password.equals(passwordField)){
                    JOptionPane.showMessageDialog(null,"Bienvenido.");
                }

                else{
                    JOptionPane.showMessageDialog(null,"Datos incorrectos.");
                    textField1.setText("");
                    passwordField1.setText("");
                }
            }
        });


    }


   }
