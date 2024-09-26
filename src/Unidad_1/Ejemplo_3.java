package Unidad_1;
import java.io.*; 
public class Ejemplo_3 {
public static void main(String[] args) throws IOException {
	File fichero = new File ("C:\\Users\\aludam2\\Desktop\\AD\\prueba.txt");
	FileReader fic= new FileReader(fichero);
	int i;
	while((i= fic.read())!=-1) {
		System.out.println((char)i);
		
	}//Fin While
	fic.close();
}
}
