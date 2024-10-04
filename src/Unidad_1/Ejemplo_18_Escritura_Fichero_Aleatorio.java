package Unidad_1;
import java.io.*;
public class Ejemplo_18_Escritura_Fichero_Aleatorio {
    public static void main(String[] args) throws IOException {
        File fichero =new File("C:\\Users\\aludam2\\Desktop\\AD\\Aleatorio.dat");
       RandomAccessFile file= new RandomAccessFile (fichero, "rw");
         String apellido[] ={"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
         Double salario[] ={1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};
         int dep[] = {10, 20, 10, 10, 30, 30, 20};
        StringBuffer buffer =null;
         int n =apellido.length;
         for (int i=0; i<n; i++) {
             file.writeInt(i + 1);

             buffer = new StringBuffer(apellido[i]);
             buffer.setLength(10);
             file.writeChars(buffer.toString());

             file.writeInt(dep[i]);
             file.writeDouble(salario[i]);
         }//Fin for
         file.close();
    }//Fin main
}//Fim Ejemplo_18_Escritura_Fichero_Aleatorio
