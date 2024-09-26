  package Unidad_1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Ejemplo_7 {
	public static void main(String[] args) throws IOException {
		File fichero= new File("C:\\Users\\aludam2\\Desktop\\AD\\provincias.txt");
		FileWriter fic = new FileWriter(fichero,true);
		String prov= "Murcia";
		fic.append(prov);
	fic.close();
	 ArrayList<String> prob= new ArrayList<String>();
	  BufferedReader br;
	  String linea;
	   br=new BufferedReader(new FileReader(fichero));
	   while((linea= br.readLine())!=null) {
		  prob.add(linea);
		}//Fin While
	   br.close();
	   prob.sort((o1, o2) -> o1.compareTo(o2));
	   fic=new FileWriter(fichero,true);
	   for(int i=0;i<prov.length();i++) {
			fic.write(prov+"\n");
		}//Fin for
	   fic.close();
	}//Fin main
}//Fin Ejemplo_7
