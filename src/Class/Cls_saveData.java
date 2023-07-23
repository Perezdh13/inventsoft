package Class;

import Forms.Frm_InsertItem;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cls_saveData extends Frm_InsertItem {

        public void saveData(JTextField ref_TextField, JTextField name_TextField, JTextField PVP_TextField, JTextField neto_TextField, JTextField units_TextField) {
            try {

                File archivoXML = new File("D:\\FactoriaF5\\Java\\inventSoftData\\stock.xml");

                FileWriter writer = new FileWriter(archivoXML);

                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                writer.write("<items>\n");

                String ref = this.ref_TextField.getText();
                String name = this.name_TextField.getText();
                String pvp = this.PVP_TextField.getText();
                String units = this.units_TextField.getText();
                String neto = this.neto_TextField.getText();

                writer.write("\t<item>\n");
                writer.write("\t\t<ref>" + ref + "</ref>\n");
                writer.write("\t\t<name>" + name + "</name>\n");
                writer.write("\t\t<pvp>" + pvp + "</pvp>\n");
                writer.write("\t\t<units>" + units + "</units>\n");
                writer.write("\t\t<neto>" + neto + "</neto>\n");
                writer.write("\t</item>\n");


                writer.write("</items>");


                writer.close();


                JOptionPane.showMessageDialog(this, "Datos guardados correctamente en datos.xml");

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los datos en XML");
            }
        }

}
