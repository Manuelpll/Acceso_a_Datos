package Unidad_1;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
public class Ejemplo_25_Crear_Archivo_XML_Empleados {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
        RandomAccessFile file = new RandomAccessFile(fichero,"r");
        int id,dep,posicion=0;
        Double salario;
        char apellido[] = new char[10],aux;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");
            for(;;){
                file.seek(posicion);
                id=file.readInt();
                for(int i=0; i<apellido.length; i++){
                    aux = file.readChar();
                    apellido[i] =aux;
                }
                String apellidos = new String(apellido);
                dep= file.readInt();
                salario= file.readDouble();
                if(id>0){
                    Element raiz = document.createElement("empleado");
                    document.getDocumentElement().appendChild(raiz);
                 CrearElemento("id",Integer.toString(id),raiz,document);
                 CrearElemento("apellido",apellidos.trim(),raiz,document);
                 CrearElemento("dep",Integer.toString(dep),raiz,document);
                 CrearElemento("salario",Double.toString(salario),raiz,document);
                }
                posicion=posicion+36;
                if(file.getFilePointer() == file.length()) break;
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
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
