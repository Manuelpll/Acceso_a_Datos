package Unidad_1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Ejemplo_34_JAXB {
    private static final String MIARCHIVO_XML = "Archivos/libreria.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        // Se crea la lista de libros
        ArrayList<Libro> libroLista = new ArrayList<>();

        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Entornos de Desarrollo", "Alicia Ramos", "Garceta", "978-84-1545-297-3");
        libroLista.add(libro1);

        Libro libro2 = new Libro("Acceso a Datos", "María Jesús Ramos", "Garceta", "978-84-1545-228-7");
        libroLista.add(libro2);


        // Se crea la Librería y se le asigna la lista de libros
        Libreria milibreria = new Libreria();
        milibreria.setListaLibro(libroLista);
        milibreria.setNombre("Prueba de libreria Unidad_1.JAXB");
        milibreria.setLugar("Talavera, como no");

        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(Libreria.class);

        // Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();

        // Formateamos el XML para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Lo visualizamos con system out
        m.marshal(milibreria, System.out);

        // Escribimos en el archivo
        m.marshal(milibreria, new File(MIARCHIVO_XML));
    }
}
