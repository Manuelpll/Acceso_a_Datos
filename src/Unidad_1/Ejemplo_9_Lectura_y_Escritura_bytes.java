package Unidad_1;
import java.io.*;
public class Ejemplo_9_Lectura_y_Escritura_bytes {
public static void main(String[] args) throws IOException {
	File fichero = new File("C:\\Users\\aludam2\\Desktop\\AD\\FichDytes.dat");
	FileOutputStream fileout = new FileOutputStream(fichero);
	FileInputStream filein = new FileInputStream(fichero);
	int i;
	//Zona de accion
	for(i=1;i<100;i++) {
	fileout.write(i);
	}
	fileout.close();
	while((i = filein.read())!=-1) {
	System.out.println(i);
	}
	filein.close();
}
}
