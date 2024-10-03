package Unidad_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo_22_Modificar_Informacion_Fichero_aleatorio {
    public static void main(String[] args) throws IOException {
        File fichero =new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
        RandomAccessFile file= new RandomAccessFile (fichero, "rw");
        Scanner sc = new Scanner(System.in);
        StringBuffer buffer =null;
        int id;
        System.out.println("Escribe el id");
        id = sc.nextInt();
        if (existeEmp(file, id)) {
            System.out.println("Se puede modificar"+"\nEscribe el apellido (No superior a 10 caracteres): ");
            String apellido = sc.nextLine() ;
            System.out.println("Escribe el salario");
            double salario = sc.nextDouble();
            System.out.println("Escribe el departamento");
            int dep = sc.nextInt();
            long posicion = (id - 1) * 36;
            file.seek(posicion);
            file.writeInt(id);
            buffer = new StringBuffer(apellido);
            buffer.setLength(10);
            file.writeChars(buffer.toString());
            file.writeInt(dep);
            file.writeDouble(salario);
        } else {
            System.out.println("El empleado no existe");
        }//Fin if-else
    }//Fin main
    private static boolean existeEmp(RandomAccessFile file, int id) throws IOException {
        file.seek(0);
        while (file.getFilePointer() < file.length()) {
            int idLeido = file.readInt();
            file.seek(file.getFilePointer() + 20 + 4 + 8);
            if (idLeido == id) {
                return true;
            }//Fin if
        }//Fin while
        return false;
    }//Fin existe
}
