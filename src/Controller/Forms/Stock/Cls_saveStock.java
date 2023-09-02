package Controller.Forms.Stock;

import Database.Cls_filePaths;
import Forms.Frm_InsertItem;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class Cls_saveStock extends Frm_InsertItem {
    static Cls_filePaths files = new Cls_filePaths();

    public void saveData(JTextField ref_TextField, JTextField name_TextField, JTextField PVP_TextField, JTextField neto_TextField, JTextField units_TextField) {
        try {

            File archivoXML = new File(files.stockFile);


            String existingContent = "";
            if (archivoXML.exists()) {
                existingContent = Files.readString(archivoXML.toPath());
            }

            String ref = ref_TextField.getText();
            String name = name_TextField.getText();
            double pvp = Double.parseDouble(PVP_TextField.getText());
            double neto = Double.parseDouble(neto_TextField.getText());
            int units = Integer.parseInt(units_TextField.getText());

            String newItem =
                    "\t<item>\n" +
                            "\t\t<ref>" + ref + "</ref>\n" +
                            "\t\t<name>" + name + "</name>\n" +
                            "\t\t<pvp>" + pvp + "</pvp>\n" +
                            "\t\t<neto>" + neto + "</neto>\n" +
                            "\t\t<units>" + units + "</units>\n" +
                            "\t</item>\n";


            String newContent = existingContent.replace("</items>", newItem + "</items>");


            FileWriter writer = new FileWriter(archivoXML);
            writer.write(newContent);
            writer.close();

            JOptionPane.showMessageDialog(this, "Datos guardados correctamente ");


        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en XML");
        }
    }

}
