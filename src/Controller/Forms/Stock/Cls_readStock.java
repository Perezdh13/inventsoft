package Controller.Forms.Stock;

import Database.Cls_filePaths;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cls_readStock {
    Cls_filePaths file = new Cls_filePaths();
    public List<Cls_Item> clsItems;
    public JScrollPane scrollPane;
    public static String selectedRef;


    public void createTable() {
        String[] columnNames = {"Ref", "Nombre", "PVP", "Neto", "Unidades"};
        Object[][] data = new Object[clsItems.size()][5];

        for (int i = 0; i < clsItems.size(); i++) {
            Cls_Item clsItem = clsItems.get(i);
            data[i][0] = clsItem.ref;
            data[i][1] = clsItem.name;
            data[i][2] = clsItem.pvp;
            data[i][3] = clsItem.neto;
            data[i][4] = clsItem.units;

        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        selectedRef = (String) table.getValueAt(selectedRow, 0);

                    }
                }
            }
        });
    }

    public void readStock() {
        File xmlFile = new File(file.stockFile);
        clsItems = new ArrayList<>();
        if (!Cls_search.results.isEmpty()) {
            for (Element element : Cls_search.results) {
                String ref = element.getElementsByTagName("ref").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                double pvp = Double.parseDouble(element.getElementsByTagName("pvp").item(0).getTextContent());
                double neto = Double.parseDouble(element.getElementsByTagName("neto").item(0).getTextContent());
                int units = Integer.parseInt(element.getElementsByTagName("units").item(0).getTextContent());
                Cls_Item clsItem = new Cls_Item(ref, name, pvp, neto, units);
                clsItems.add(clsItem);
            }
        } else {

            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);

                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("item");


                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element personElement = (Element) nodeList.item(i);
                    String ref = personElement.getElementsByTagName("ref").item(0).getTextContent();
                    String name = personElement.getElementsByTagName("name").item(0).getTextContent();
                    double pvp = Double.parseDouble(personElement.getElementsByTagName("pvp").item(0).getTextContent());
                    double neto = Double.parseDouble(personElement.getElementsByTagName("neto").item(0).getTextContent());
                    int units = Integer.parseInt(personElement.getElementsByTagName("units").item(0).getTextContent());
                    Cls_Item clsItem = new Cls_Item(ref, name, pvp, neto, units);
                    clsItems.add(clsItem);
                }


            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
        }
    }
}


