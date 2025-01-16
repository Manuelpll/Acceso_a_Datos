package Unidad_2;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
public class Ejemplo_1_Crear_Base_Datos_Db4o {
    static String BDPer ="DBPersonas.yap";
    public static void main(String[] args) {
        ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDPer);
        Persona p1 = new Persona("Juan","Guadalajara");
        Persona p2 = new Persona("Ana","Madid");
        Persona p3 = new Persona("Luis","Granada");
        Persona p4 = new Persona("Pedro","Asturias");
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.close();
    }//Fin main
}
