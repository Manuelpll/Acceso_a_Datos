package Unidad_1;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


public class Ejemplo_27_Objetos_Canciones_a_XML {
    public static void main(String[] args) throws IOException {
        File objeto = new File("C:\\Users\\aludam2\\Desktop\\AD\\Canciones.dat");
        FileInputStream fis = new FileInputStream(objeto);// Crear un flujo de entrada a la RAM
        ObjectInputStream datain = new ObjectInputStream(fis);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        int id;
        Cancion c;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "Canciones", null); //Es el objeto que crea el arbol en la Ram
            document.setXmlVersion("1.0");

            while (true) {
                try {
                    c = (Cancion) datain.readObject(); //Deserializa
                    id = c.getIdentificador();

                    if (id > 0) {
                        Element raiz = document.createElement("cancion");
                        document.getDocumentElement().appendChild(raiz);
                        CrearElemento("id", Integer.toString(c.getIdentificador()), raiz, document);
                        CrearElemento("año", Integer.toString(c.getAño()), raiz, document);
                        CrearElemento("titulo", c.getTitulo(), raiz, document);
                        CrearElemento("artista", c.getArtista(), raiz, document);
                        CrearElemento("duracion", c.getDuracion(), raiz, document);
                        CrearElemento("Es_Española", Boolean.toString(c.getCancionEspañola()), raiz, document);
                    }//Fin if

                } catch (EOFException eof) {
                    System.out.println("Fin del archivo alcanzado.");
                    break;
                }//Fin try-catch
            }//Fin while
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("Canciones2.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(source, result);
            //Mostrar el documento por consola
            Result console = new StreamResult(System.out);
            tf.transform(source, console);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        } finally {
            datain.close();
            fis.close();
        }//Fin try-catch-finally
    }//Fin main
    static void CrearElemento (String datoCan, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoCan);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }//Fin CrearElemento
}//Fin Ejemplo_27_Objetos_Canciones_a_XML