package Unidad_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo_21_Lectura_Fichero_Aleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        Scanner scanner = new Scanner(System.in);
        int id = 0, dep, eleccion;
        double salario;
        char[] apellido = new char[10];
        char aux;

        System.out.println("Ingrese el ID del empleado");
        eleccion = scanner.nextInt();
        long posicion = (eleccion - 1) * 36;
        if (posicion >= file.length()) {
            System.out.println("No se encontró el empleado.");
        } else {
            file.seek(posicion);
            id = file.readInt();
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }
            String apellidos = new String(apellido).trim();
            dep = file.readInt();
            salario = file.readDouble();
            if (id == eleccion) {
                System.out.printf("ID: %d, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos, dep, salario);
            } else {
                System.out.println("No se encontró el empleado.");
            }//Fin 2ºif-else
        }//Fin if
        file.close();
    }//Fin main
}//Fin Ejemplo_21_Lectura_Fichero_Aleatorio
