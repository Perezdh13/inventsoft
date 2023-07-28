package Controller.Forms.Stock;

import Database.Cls_filePaths;
import Forms.Frm_Stock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Cls_readStock {
 Cls_filePaths file = new Cls_filePaths();
 public String ref;
 public String name;
 public int pvp;
 public int neto;
 public int units;
    public void readStock() {
        File xmlFile = new File(file.stockFile);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("items");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element personElement = (Element) nodeList.item(i);
                 ref = personElement.getElementsByTagName("ref").item(0).getTextContent();
               name = personElement.getElementsByTagName("name").item(0).getTextContent();
                 pvp = Integer.parseInt(personElement.getElementsByTagName("pvp").item(0).getTextContent());
                 neto = Integer.parseInt(personElement.getElementsByTagName("neto").item(0).getTextContent());
                units = Integer.parseInt(personElement.getElementsByTagName("units").item(0).getTextContent());
                System.out.println("Ref: " + ref + ", Nombre: " + name + ", PVP: " + pvp + ", Neto: " + neto + ", unidades: " + units);
            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}


