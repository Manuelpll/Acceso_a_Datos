package Unidad_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejemplo_29_Leer_Archivo_XML_Peliculas {
    public static void main(String[] args) throws IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(new File("Peliculas.xml"));
            doc.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: %s %n", doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("movie");
            System.out.printf("Nodos empleado a recorrer: %s %n", nList.getLength());
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    System.out.println("----------------");
                    System.out.printf("Titulo = %s %n", element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.printf("Director = %s %n", element.getElementsByTagName("director").item(0).getTextContent());
                    System.out.printf("Año = %s %n", element.getElementsByTagName("year").item(0).getTextContent());
                    System.out.printf("Genero = %s %n", element.getElementsByTagName("genre").item(0).getTextContent());
                    System.out.printf("Valoracion = %s %n", element.getElementsByTagName("rating").item(0).getTextContent());
                    System.out.println("----------------");
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
