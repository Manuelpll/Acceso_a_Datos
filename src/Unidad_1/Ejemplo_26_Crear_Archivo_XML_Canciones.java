package Unidad_1;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
public class Ejemplo_26_Crear_Archivo_XML_Canciones {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\CancionesAle.dat");
        RandomAccessFile file = new RandomAccessFile(fichero,"r");
        int posicion=0;
        char titulo[] = new char[20];
        char artista[] = new char[20],aux ,auy,auz;
        char duracion[] = new char[20];
        int id;
        int año;
        boolean cancionEspañola;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "Canciones", null);
            document.setXmlVersion("1.0");
            for(;;){
                file.seek(posicion);
                id=file.readInt();
                año=file.readInt();
                for(int i=0; i<titulo.length; i++){
                    aux = file.readChar();
                    titulo[i] =aux;
                }
                String titulos = new String(titulo);
                for(int i=0; i<artista.length; i++){
                    auy = file.readChar();
                    titulo[i] =auy;
                }
                String artistas = new String(titulo);
                for(int i=0; i<duracion.length; i++){
                    auz= file.readChar();
                    duracion[i] =auz;
                }
                String duraciones = new String(duracion);
                cancionEspañola = file.readBoolean();
                if(id>0){
                    Element raiz = document.createElement("cancion");
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("id",Integer.toString(id),raiz,document);
                    CrearElemento("año",Integer.toString(año),raiz,document);
                    CrearElemento("titulo",titulos.trim(),raiz,document);
                    CrearElemento("artista",artistas.trim(),raiz,document);
                    CrearElemento("duracion",duraciones.trim(),raiz,document);
                    CrearElemento("Es_Española",Boolean.toString(cancionEspañola),raiz,document);
                }
                posicion=posicion+129;
                if(file.getFilePointer() == file.length()) break;
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Archivos/Canciones.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(source,result);
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tf.transform(source,result);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    static void CrearElemento (String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }//Fin CrearElemento
    }
