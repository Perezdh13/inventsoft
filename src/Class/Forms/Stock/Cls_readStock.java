package Class.Forms.Stock;

import Database.Cls_filePaths;
import Forms.Frm_Stock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Cls_readStock extends Frm_Stock {
 static Cls_filePaths file = new Cls_filePaths();

    public void readStock(JTable stockTable) {
        File xmlFile = new File(file.stockFile);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Obtener el elemento raíz del documento XML
            Element rootElement = doc.getDocumentElement();

            // Aquí puedes comenzar a trabajar con los elementos y atributos del archivo XML
            // Por ejemplo, si el archivo contiene etiquetas <elemento> con atributo "valor":
            NodeList nodeList = rootElement.getElementsByTagName("elemento");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String valor = element.getAttribute("valor");
                    System.out.println("Valor: " + valor);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


