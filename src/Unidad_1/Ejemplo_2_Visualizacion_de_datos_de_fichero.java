package Unidad_1;
import java.io.*;
/**
 * Programa que muestra la informacion de un fichero
 * @author Mpll
 * @date 18/09/2024
 */
public class Ejemplo_2_Visualizacion_de_datos_de_fichero {
public static void main (String[] args) {
	System.out.println("INFORMACION SOBRE EL FICHERO");
	File f = new File("C:\\Users\\aludam2\\Desktop\\AD\\prueba.txt");
	if(f.exists()) {
		System.out.println("Nombre de fichero:"+f.getName());
		System.out.println("Ruta  :"+f.getPath());
		System.out.println("Ruta absoluta  :"+f.getAbsolutePath());
		System.out.println("Se puede leer  :"+f.canRead());
		System.out.println("Se puede escribir :"+f.canWrite());
		System.out.println("Tamaño            :"+f.length());
		System.out.println("Es un directorio :"+f.isDirectory());
		System.out.println("Es un fichero      :"+f.isFile());
		System.out.println("Nombre del directorio padre :"+f.getParent());
		
	}//Fin IF
}//Fin main
}//Fin Ejemplo 2
