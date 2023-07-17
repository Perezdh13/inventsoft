import Forms.Frm_Login;

import javax.swing.*;

public class Cls_Main {
    public static void main(String[] args){
//creo la instacia
        Frm_Login loginForm = new Frm_Login();

        //Configuro las propiedades del formulari
        JFrame frame = new JFrame("formulario inicio de sesion");
        frame.setContentPane(loginForm.login_Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);//centra la ventana
        frame.setVisible(true);


    }
}
