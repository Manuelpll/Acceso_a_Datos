package Unidad_1;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ejemplo_30_Escribir_XStream {
    public static void main(String[] args) throws IOException {
        File fichero= new File("C:\\Users\\aludam2\\Desktop\\AD\\FichPersona.dat");
        FileInputStream fis = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("Comienza el proceso");
        ListaPersonas listaper = new ListaPersonas();

        try{
            while(true){
                Persona persona = (Persona) ois.readObject();
                listaper.add(persona);
            }//Fin while
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado.");
        }finally {
            ois.close();
        }//Fin de try-cach-finally
        try {
            XStream xstream = new XStream(); //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("DatosPersona", Persona.class);
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersonas.class, "list");
            //Insertar los objetos en el XML
            xstream.toXML(listaper, new FileOutputStream("Archivos/Personas.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
