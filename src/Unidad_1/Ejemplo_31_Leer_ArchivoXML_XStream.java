package Unidad_1;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
public class Ejemplo_31_Leer_ArchivoXML_XStream {
    public static void main(String[] args) throws IOException {
        XStream xstream = new XStream();

        // Alias para cambiar los nombres de las etiquetas en el XML
        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersona", Persona.class);

        // Quitar la etiqueta de la colección lista en ListaPersonas
        xstream.addImplicitCollection(ListaPersonas.class, "list");

        // Leer el XML y convertirlo en un objeto ListaPersonas
        ListaPersonas listadoTodas = (ListaPersonas) xstream.fromXML(new FileInputStream("Personas.xml"));

        // Mostrar el número total de personas
        System.out.println("Número de Personas: " + listadoTodas.getList().size());

        // Obtenemos la lista de personas
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = listadoTodas.getList();

        // Iteramos sobre la lista de personas
        Iterator<Persona> iterador = listaPersonas.listIterator();
        while (iterador.hasNext()) {
            Persona p = (Persona) iterador.next();
            System.out.printf("Nombre: %s, edad: %d%n", p.getNombre(), p.getEdad());
        }

        System.out.println("Fin del listado.");
    }
}
