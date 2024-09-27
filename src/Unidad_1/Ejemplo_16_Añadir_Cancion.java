package Unidad_1;

import java.io.*;
import java.util.Scanner;

public class Ejemplo_16_Añadir_Cancion {
    public static void main(String[] args) throws IOException {
        Cancion cancion;
        Scanner teclado = new Scanner(System.in);
        File archivo = new File("C:\\Users\\aludam2\\Desktop\\AD\\Canciones.dat");
        ObjectOutputStream dataOs;
        int identificador;
        int año;
        int decision=1;
        String titulo;
        String artista;
        String duracion;
        String respuesta;
        boolean cancionEspañola;
        if (archivo.exists()) {
            dataOs = new ObjectOutputStream(new FileOutputStream(archivo));
        }else{
            FileOutputStream fos = new FileOutputStream(archivo);
            dataOs = new ObjectOutputStream(fos);
        }
        while (decision == 1) {
            System.out.println("Escribe su identificador");
            identificador= teclado.nextInt();
            System.out.println("Escribe el año de la cancion");
            año= teclado.nextInt();
            System.out.println("Escribe el titulo de la cancion");
            titulo= teclado.next();
            teclado.nextLine();
            System.out.println("Escribe su artista");
            artista= teclado.next();
            teclado.nextLine();
            System.out.println("Escribe su duracion");
            duracion= teclado.next();
            System.out.println("""
                         ¿Es una cancion española?
                         True / False""");
            cancionEspañola= Boolean.parseBoolean(teclado.next());
            cancion= new Cancion(identificador,año,titulo,artista,duracion,cancionEspañola);
            dataOs.writeObject(cancion);
            System.out.println("""
                     Pulsa 1 si quieres añadir una cancion
                     Pulsa cualquier otro numero si ya no quieres añadir más""");
            decision= teclado.nextInt();
        }//Fin while
        dataOs.close();
    }
}
