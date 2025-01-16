package Unidad_3;
import org.neodatis.odb.*;
public class EjemploNeodatis {
    public static void main(String[] args) {
        // Crear instancias para almacenar en BD
        Jugadores j1 = new Jugadores("Maria", "Voleibol", "Madrid", 14);
        Jugadores j2 = new Jugadores("Miguel", "Tenis", "Madrid", 15);
        Jugadores j3 = new Jugadores("Mario", "Cuadraláser", "Madrid", 15 );
        Jugadores j4 = new Jugadores("Alicia", "Tenis", "Madrid", 14);

        ODB odb = ODBFactory.open("neodatis.test"); // Abrir BD

        // Almacenar objetos
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);

        // Recuperar todos los objetos
        Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
        System.out.println("Jugadores: " + objects.size());

        // Visualizar los objetos
        while (objects.hasNext()) {
            Jugadores jug = objects.next();
            System.out.println(jug.getNombre() + ", " + jug.getDeporte() + ", " + jug.getCiudad() + ", " + jug.getEdad());
        }

        odb.close(); // Cerrar BD
    }
}
