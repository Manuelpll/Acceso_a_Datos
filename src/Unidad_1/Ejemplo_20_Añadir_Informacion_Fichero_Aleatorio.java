package Unidad_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo_20_Añadir_Informacion_Fichero_Aleatorio {
    public static void main(String[] args) throws IOException {
        File fichero =new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
        RandomAccessFile file= new RandomAccessFile (fichero, "rw");
        StringBuffer buffer =null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el apellido (No superior a 10 caracteres): ");
        String apellido = sc.nextLine() ;
        System.out.println("Escribe el salario");
        double salario = sc.nextDouble();
        System.out.println("Escribe el id");
        int id = sc.nextInt();
        System.out.println("Escribe el departamento");
        int dep = sc.nextInt();
        if(existeEmpleado(file,id)){
            System.out.println("El empleado ya existe");
        }else {
            long posicion = (id - 1) * 36;
            file.seek(posicion);
            file.writeInt(id);
            buffer = new StringBuffer(apellido);
            buffer.setLength(10);
            file.writeChars(buffer.toString());
            file.writeInt(dep);
            file.writeDouble(salario);
            file.close();
        }//Fin if-else
    }//Fin main
    private static boolean existeEmpleado(RandomAccessFile file, int id) throws IOException {
        file.seek(0);
        while (file.getFilePointer() < file.length()) {
            int idLeido = file.readInt();
            file.seek(file.getFilePointer() + 20 + 4 + 8);
            if (idLeido == id) {
                return true;
            }//Fin if
        }//Fin while
        return false;
    }//Fin existe empleado
}//Fin Ejemplo_20_Añadir_Informacion_Fichero_Aleatorio
