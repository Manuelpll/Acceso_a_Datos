package Unidad_1;

import java.io.*;
import java.util.Scanner;

public class Ejemplo_17_Buscar_Cancion {
    public static void main(String[] args) throws IOException {
        Cancion c;
        File archivo = new File("C:\\Users\\aludam2\\Desktop\\AD\\Canciones.dat");
        FileInputStream fis= new FileInputStream(archivo);
        ObjectInputStream datain= new ObjectInputStream(fis);
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el artista ");
        String titulo = sc.nextLine();
        try {
            while (true){
                c =(Cancion) datain.readObject();
                if (titulo.equals(c.getArtista())){
                    System.out.println(c);
                }
            }//Fin while
        }catch (EOFException | ClassNotFoundException e){
            System.out.println("Fin de lectura");
        }//Fin try-catch
        datain.close();
    }
}//Fin de Ejemplo_17_Buscar_Cancion
