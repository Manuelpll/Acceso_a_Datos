package Unidad_1;

import java.io.*;

public class Ejemplo_13_Lectura_Bytes_Objeto {
    public static void main(String[] args) throws IOException {
        Persona persona;
        File archivo= new File("C:\\Users\\aludam2\\Desktop\\AD\\FichPersona.dat");
        FileOutputStream fos= new FileOutputStream(archivo);
        ObjectOutputStream dataOs = new ObjectOutputStream(fos);
        FileInputStream fis= new FileInputStream(archivo);
        ObjectInputStream datain= new ObjectInputStream(fis);
        String nombre[]= {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María Jesús"};
        int edades[]= {14,15,13,16,12,16,14,13};
        //Fin
        for (int i = 0; i <edades.length ; i++) {
            persona= new Persona(nombre[i],edades[i]);
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
