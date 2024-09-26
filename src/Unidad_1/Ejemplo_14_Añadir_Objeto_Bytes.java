package Unidad_1;

import java.io.*;

public class Ejemplo_14_Añadir_Objeto_Bytes {
    public static void main(String[] args) throws IOException {
        Persona persona;
        File archivo= new File("C:\\Users\\aludam2\\Desktop\\AD\\FichPersona.dat");
        FileOutputStream fos= new FileOutputStream(archivo,true);
        ObjectOutputStream dataOs = new ObjectOutputStream(fos);
        FileInputStream fis= new FileInputStream(archivo);
        ObjectInputStream datain= new ObjectInputStream(fis);
        String nombre="Borja";
        int edades= 21;
        //Fin
        for (int i = 0; i <2 ; i++) {
            persona= new Persona(nombre,edades);
            dataOs.writeObject(persona);
        }
        dataOs.close();
        try {
            while (true){
                persona =(Persona) datain.readObject();
                System.out.printf("Nombre: %s\nEdad: %d\n",persona.getNombre(),persona.getEdad());
            }
        }catch (EOFException | ClassNotFoundException e){
            System.out.println("Fin de lectura");
        }
        datain.close();
    }
}
