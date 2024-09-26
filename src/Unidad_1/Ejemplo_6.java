package Unidad_1;
import java.io.*;
import java.util.Arrays;
public class Ejemplo_6 {
    static void arrayReverse(String[] array){
        for (int i=0;i< array.length/2;i++){
           String temp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=temp;
        }//Fin for
    }//Fin arrayReverse
	public static void main(String[] args) throws IOException {
		File fichero= new File("C:\\Users\\aludam2\\Desktop\\provincias.txt");
		FileWriter fic = new FileWriter(fichero);
		String prov []= {"Albacete","Avila","Badajoz","Caceres","Segovia","Huelva","Jaén","Madrid","Segovia","Soria","Toledo","Valladolid","Zamora"};
		arrayReverse(prov);
		for(int i=0;i<prov.length;i++) {
			fic.write(prov[i]+"\n");
		}//Fin for
		fic.close();
	}//Fin main
}//Ejemplo_6
   