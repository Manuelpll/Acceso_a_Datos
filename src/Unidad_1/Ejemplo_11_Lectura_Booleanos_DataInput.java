package Unidad_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo_11_Lectura_Booleanos_DataInput {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\FichData.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		FileInputStream filein = new FileInputStream(fichero);
		DataOutputStream datout = new DataOutputStream(fileout);
		DataInputStream datin = new DataInputStream(filein);
		String nombre[]= {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María Jesús"};
		boolean as[]= {true,false,false,true,false,true,false,true};
		String n;
		boolean e;
		String asis = null;
		//Zona de accion
		for(int i=0;i<as.length;i++) {
		datout.writeUTF(nombre[i]);
		datout.writeBoolean(as[i]);
		}//Fin for
		fileout.close();
		try {
		while(true) {
		n= datin.readUTF();
		e=datin.readBoolean();
		   if (e) {
               asis = "Si";
			   System.out.println("Nombre:"+n+" Asiste:"+asis);
           } else {
               asis = "No";
           }//Fin if
		}//Fin while
		
		}catch(EOFException eo) {}//Fin try-catch
		datin.close();
		}//Fin main
}//Fin Ejemplo_11_Lectura_Booleanos_DataInput