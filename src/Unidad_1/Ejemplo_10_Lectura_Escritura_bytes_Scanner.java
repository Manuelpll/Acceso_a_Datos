package Unidad_1;

import java.io.*;
import java.util.Scanner;
public class Ejemplo_10_Lectura_Escritura_bytes_Scanner {
	public static void main(String[] args) throws IOException {
	File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\FichData.dat");
	FileOutputStream fileout = new FileOutputStream(fichero);
	FileInputStream filein = new FileInputStream(fichero);
	DataOutputStream datout = new DataOutputStream(fileout);
	DataInputStream datin = new DataInputStream(filein);
	String nombre[]= {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María Jesús"};
	int edades[]= {14,15,13,16,12,16,14,13};
	String n;
	int e;
	//Zona de accion
	for(int i=0;i<edades.length;i++) {
	datout.writeUTF(nombre[i]);
	datout.writeInt(edades[i]);
	}//Fin for
	fileout.close();
	try {
	while(true) {
	n= datin.readUTF();
	e=datin.readInt();
	System.out.println("Nombre:"+n+", edad:"+e);
	}//Fin while
	
	}catch(EOFException eo) {}//Fin try-catch
	datin.close();
	}//Fin main
}//Fin Ejemplo_10_Lectura_Escritura_bytes_Scanner
