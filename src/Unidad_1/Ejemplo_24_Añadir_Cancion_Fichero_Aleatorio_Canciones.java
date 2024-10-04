package Unidad_1;

import java.io.*;
import java.util.Scanner;

/* Apartir del fichero binario de objeto canciones crear un fichero aleatorio de canciones y
 una clase que permita añadir una cancion y otra que permita buscar otra cancíon
4+4+40+40+40+1=129
 */
public class Ejemplo_24_Añadir_Cancion_Fichero_Aleatorio_Canciones {
    public static void main(String[] args) throws IOException {
        File objeto = new File("C:\\Users\\aludam2\\Desktop\\AD\\Canciones.dat");
        File aleatorio = new File("C:\\Users\\aludam2\\Desktop\\AD\\CancionesAle.dat");
        ObjectOutputStream dataOs;
        FileInputStream fis= new FileInputStream(objeto);
        ObjectInputStream datain= new ObjectInputStream(fis);
        RandomAccessFile file= new RandomAccessFile (aleatorio, "rw");
        Scanner teclado = new Scanner(System.in);
        StringBuffer buffer =null;
        long logitud;
        Cancion cancion;
        int id , idUltimo = 0;
        int año;
        int decision=1;
        String titulo ;
        String artista;
        String duracion;
        boolean cancionEspañola;
        if (objeto.exists()) {
            dataOs = new MiObjectOutputStream(new FileOutputStream(objeto, true));
        }else{
            FileOutputStream fos = new FileOutputStream(objeto);
            dataOs = new ObjectOutputStream(fos);
        }  try {
            while (true){
                cancion =(Cancion) datain.readObject();
               idUltimo= cancion.getIdentificador();
            }//Fin while
        }catch (EOFException | ClassNotFoundException e){
            System.out.println(" ");
        }//Fin try-catch
        while (decision == 1) {
            System.out.println("Escribe el año de la cancion");
            año= teclado.nextInt();
            System.out.println("Escribe el titulo de la cancion");
            titulo= teclado.nextLine();
            teclado.nextLine();
            System.out.println("Escribe su artista");
            artista= teclado.next();
            teclado.nextLine();
            System.out.println("Escribe su duracion");
            duracion= teclado.next();
            teclado.nextLine();
            System.out.println("""
                         ¿Es una cancion española?
                         True / False""");
            cancionEspañola= Boolean.parseBoolean(teclado.next());
            cancion = new Cancion(idUltimo, año, titulo, artista, duracion, cancionEspañola);
            dataOs.writeObject(cancion);
            System.out.println("""
                     Pulsa 1 si quieres añadir una cancion
                     Pulsa cualquier otro numero si ya no quieres añadir más""");
            decision= teclado.nextInt();
            idUltimo +=1;
        }//Fin while
        dataOs.close();
        try {
            while (true){
                cancion =(Cancion) datain.readObject();
                id=cancion.getIdentificador();
                logitud= (id-1)*129;
                file.seek(logitud);
                file.writeInt(id);
                año= cancion.getAño();
                file.writeInt(año);
                titulo= cancion.getTitulo();
                buffer=new StringBuffer(titulo);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                artista= cancion.getArtista();
                buffer=new StringBuffer(artista);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                duracion= cancion.getDuracion();
                buffer=new StringBuffer(duracion);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                cancionEspañola= cancion.getCancionEspañola();
                file.writeBoolean(cancionEspañola);
            }//Fin while
        }catch (EOFException e){
            System.out.println("Fin de lectura");
        }//Fin try-catch
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        datain.close();
        file.close();
    }//Fin main
}//Fin Ejemplo_24_Crear_Fichero_Aleatorio_Canciones
