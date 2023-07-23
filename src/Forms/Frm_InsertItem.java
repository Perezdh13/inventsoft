package Forms;

import Class.Cls_saveData;

import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frm_InsertItem extends JFrame {
    public JButton add_Button;
    public JLabel Ref;
    public JLabel Name;
    public JLabel PVP;
    public JPanel insertItem;
    public JTextField neto_TextField;
    public JTextField PVP_TextField;
    public JTextField name_TextField;
    public JTextField ref_TextField;
    public JTextField units_TextField;
    public JLabel Units;

    public Frm_InsertItem() {
        add_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cls_saveData save = new Cls_saveData();
                save.saveData(ref_TextField,name_TextField,PVP_TextField,neto_TextField,units_TextField);

            }
        });
    }

   /* private void guardarDatosEnXML() {
        try {
            // Crear un nuevo archivo XML (puedes cambiar la ruta y el nombre del archivo)
            File archivoXML = new File("D:\\FactoriaF5\\Java\\inventSoftData\\stock.xml");

            // Crear un FileWriter para escribir en el archivo
            FileWriter writer = new FileWriter(archivoXML);

            // Escribir la cabecera del archivo XML
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<items>\n");

            // Obtener los valores de los JTextFields
            String ref = ref_TextField.getText();
            String name = name_TextField.getText();
            String pvp = PVP_TextField.getText();
            String units = units_TextField.getText();
            String neto = neto_TextField.getText();

            // Escribir los datos en el archivo XML
            writer.write("\t<item>\n");
            writer.write("\t\t<ref>" + ref + "</ref>\n");
            writer.write("\t\t<name>" + name + "</name>\n");
            writer.write("\t\t<pvp>" + pvp + "</pvp>\n");
            writer.write("\t\t<units>" + units + "</units>\n");
            writer.write("\t\t<neto>" + neto + "</neto>\n");
            writer.write("\t</item>\n");

            // Cerrar el elemento raíz del archivo XML
            writer.write("</items>");

            // Cerrar el FileWriter
            writer.close();

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en datos.xml");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en XML");
        }
    }*/
}
