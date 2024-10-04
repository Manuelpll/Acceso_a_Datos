package Unidad_1;

import java.io.*;

public class Ejemplo_23_Crear_Fichero_Aleatorio_Canciones {
    public static void main(String[] args) throws IOException {
        File objeto = new File("C:\\Users\\aludam2\\Desktop\\AD\\Canciones.dat");
        File aleatorio = new File("C:\\Users\\aludam2\\Desktop\\AD\\CancionesAle.dat");
        RandomAccessFile file= new RandomAccessFile (aleatorio, "rw");
        FileInputStream fis= new FileInputStream(objeto);
        ObjectInputStream datain= new ObjectInputStream(fis);
        StringBuffer buffer =null;
        long logitud;
        int id;
        int año;
        String titulo;
        String artista;
        String duracion;
        boolean cancionEspañola;
        Cancion c;
        try {
            while (true){
                c =(Cancion) datain.readObject();

                id=c.getIdentificador();

                logitud= (id-1)*129;

                file.seek(logitud);
                file.writeInt(id);
                año= c.getAño();
                file.writeInt(año);
                titulo= c.getTitulo();
                buffer=new StringBuffer(titulo);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                artista= c.getArtista();
                buffer=new StringBuffer(artista);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                duracion= c.getDuracion();
                buffer=new StringBuffer(duracion);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                cancionEspañola= c.getCancionEspañola();
                file.writeBoolean(cancionEspañola);
            }//Fin while
        }catch (EOFException | ClassNotFoundException e){
            System.out.println("Fin de lectura");
        }//Fin try-catch
        datain.close();
        file.close();
    }//Fin main
    }//Fin Ejemplo_23_Crear_Fichero_Aleatorio_Canciones
