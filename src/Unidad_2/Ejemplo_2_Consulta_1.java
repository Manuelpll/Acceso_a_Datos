package Unidad_2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ejemplo_2_Consulta_1 {
    static String BDPer = "DBPersonas.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);

        try {
            Persona per = new Persona(null, "Guadalajara");
            ObjectSet<Object> result = db.queryByExample(per);

            if (result.isEmpty()) {
                System.out.println("No existen Registros de Personas..");
            } else {
                System.out.printf("Número de registros: %d %n", result.size());
                while (result.hasNext()) {
                    Persona p = (Persona) result.next();
                    System.out.printf("Nombre: %s, Ciudad: %s %n", p.getNombre(), p.getCiudad());
                }
            }
        } finally {
            db.close(); // cerrar base de datos
        }
    }
}
