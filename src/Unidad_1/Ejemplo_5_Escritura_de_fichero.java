package Unidad_1;
import java.io.*;
public class Ejemplo_5_Escritura_de_fichero {

	public static void main(String[] args) throws IOException {
		File fichero= new File("C:\\Users\\aludam2\\Desktop\\AD\\nuevo.txt");
		FileWriter fic = new FileWriter(fichero);
		String cadena = "Esto es una prueba con FileWriter";
		char [] cad= cadena.toCharArray();
		for(int i = 0;i<cad.length;i++) {
		fic.write(cad[i]);
		fic.append('*');
		}//Fin for
		fic.close();
	}//Fin main

}
