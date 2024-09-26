package Unidad_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Programa que lee un programa de 20 en 20
 * @author Mpll
 */
public class Ejemplo_4 {
	/**
	 * Metodo principal que ejecuta el program
	 * @param args - Los argumentos de la linea de comandos
	 * @throws IOException Si no se encuentra el archivo o hay aolgun problema
	 */
	public static void main(String[] args) throws IOException {
		File fichero = new File ("C:\\Users\\aludam2\\Desktop\\AD\\prueba.txt");
		FileReader fic= new FileReader(fichero);
		char b []= new char[20];
		while((fic.read(b))!=-1) {
			System.out.println((b));
			
		}//Fin While
		fic.close();
	}//Fin main
}//Fin Ejemplo_4
