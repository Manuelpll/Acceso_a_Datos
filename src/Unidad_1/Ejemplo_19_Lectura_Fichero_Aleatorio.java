package Unidad_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo_19_Lectura_Fichero_Aleatorio {
    public static void main(String[] args) throws IOException {
        File fichero =new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
        RandomAccessFile file= new RandomAccessFile (fichero, "r");
        int id,dep,posicion;
        double salario;
        char[] apellido = new char[10];
        char aux;
        posicion=0;
        for(;;){
            file.seek(posicion);
            id=file.readInt();
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i]=aux;
            }//Fin 2ºfor
            String apellidos=new String(apellido);
            dep=file.readInt();
            salario=file.readDouble();
            if(id>0){
                System.out.printf ("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",id, apellidos.trim(), dep, salario);
            }//Fin if
            posicion=posicion+36;
            if(file.getFilePointer()== file.length()) break;
        }//Fin for
    }//Fin main
}//Fin Ejemplo_19_Lectura_Fichero_Aleatorio
