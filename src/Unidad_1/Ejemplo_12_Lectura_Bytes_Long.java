package Unidad_1;

import java.io.*;

public class Ejemplo_12_Lectura_Bytes_Long {
    public static void main(String[] args) throws IOException {

        File f2 = new File("C:\\Users\\aludam2\\Desktop\\AD\\primitivos.dat");
        FileOutputStream fileout = new FileOutputStream(f2,true);
        DataOutputStream dataOS = new DataOutputStream(fileout);
         long a =123;
         dataOS.writeLong(a);
        int v ;
        char c;
        boolean b;
        String n;
        byte by ;
        dataOS.close();
        FileInputStream filein = new FileInputStream(f2);
        DataInputStream dataIS = new DataInputStream(filein);
        try {
            while(dataIS.available()>0) {
                by=dataIS.readByte();
                System.out.println("Esto es un Byte: "+by);
                c=dataIS.readChar();
                System.out.println("Esto es un Caracter: "+c);
                b=dataIS.readBoolean();
                System.out.println("Esto es un Boolean: "+b);
                v=dataIS.readInt();
                System.out.println("Esto es un entero: "+v);
                n=dataIS.readUTF();
                System.out.println("Esto es un String: "+n);
                a=dataIS.readLong();
                System.out.println("Esto es un Long: "+a);
            }//Fin while

        }catch(EOFException eo) {
            System.out.println("Error");
        }//Fin try-catch

        dataIS.close();
    }//Fin main
    }//Fin Ejemplo_12_Lectura_Bytes_Long
