package Controller.Forms.Stock;

import Database.Cls_filePaths;
import Forms.Frm_Stock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Cls_search extends Frm_Stock {
    static Cls_filePaths files = new Cls_filePaths();

    public static List<Element> results = new ArrayList<>();


    public List<Element> searchItem(JTextField searchField) {

        try {
            File archivoXML = new File(files.stockFile);

            if (archivoXML.exists()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(archivoXML);

                XPathFactory xPathFactory = XPathFactory.newInstance();
                XPath xpath = xPathFactory.newXPath();

                 String searchExpression = "//item[name='" + searchField.getText() + "' or ref='" + searchField.getText() + "']";
                XPathExpression expr = xpath.compile(searchExpression);


                NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);


                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element itemElement = (Element) nodeList.item(i);
                    results.add(itemElement);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Element result : results) {
            System.out.println("Elemento encontrado:");
            System.out.println("Nombre: " + result.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Referencia: " + result.getElementsByTagName("ref").item(0).getTextContent());

        }
        return results;
    }
}
