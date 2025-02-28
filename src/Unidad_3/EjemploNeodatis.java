package Unidad_3;
import org.neodatis.odb.*;
public class EjemploNeodatis {
    public static void main(String[] args) {
        Pais pais = new Pais(1, "Butano");

        // Crear instancias para almacenar en la BD
        Jugadores j1 = new Jugadores("Maria", "Voleibol", "Madrid", 14, pais);
        Jugadores j2 = new Jugadores("Miguel", "Tenis", "Madrid", 15, pais);
        Jugadores j3 = new Jugadores("Mario", "Cuadraláser", "Madrid", 15, pais);
        Jugadores j4 = new Jugadores("Alicia", "Tenis", "Madrid", 14, pais);

        ODB odb = ODBFactory.open("neodatis.test"); // Abrir BD

        try {
            // Almacenar objetos
            odb.store(j1);
            odb.store(j2);
            odb.store(j3);
            odb.store(j4);
            odb.commit(); // Asegurar persistencia

            // Recuperar todos los objetos
            Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
            System.out.println("Jugadores: " + objects.size());

            // Visualizar los objetos
            for (Jugadores jug : objects) {
                System.out.println(jug.getNombre() + ", " + jug.getDeporte() + ", " + jug.getCiudad() + ", " + jug.getEdad());
            }
        } finally {
            odb.close(); // Cerrar BD
        }
    }
}
