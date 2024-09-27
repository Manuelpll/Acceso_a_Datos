package Unidad_1;

import java.io.Serializable;

/*
Identificador,año, String titulo 20 c,artista 20 c,duracion, boo cancion española , Contructor normal , año=0 Identificador=0 titulo artista duracion cancion española fales
 */
public class Cancion implements Serializable {
    private int identificador;
    private int año;
    private String titulo;
    private String artista;
    private String duracion;
    private boolean cancionEspañola;
    public Cancion(int identificador,int año,String titulo,String artista,String duracion,boolean cancionEspañola) {
        this.identificador = identificador;
        this.año = año;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.cancionEspañola = cancionEspañola;
    }
    public Cancion() {
        this.identificador = 0;
        this.año=0;
        this.titulo = null;
        this.artista = null;
        this.duracion = null;
        this.cancionEspañola = false;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public void setCancionEspañola(boolean cancion) {
        this.cancionEspañola = cancion;
    }
    public  Boolean getCancionEspañola(){
        return  cancionEspañola;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return "--------------------"+"\nID:"+identificador+"\nAño:"+año+"\nTitulo: "+titulo+"\nArtista: "+artista+"\nDuracion: "+duracion+"\nEs española?:"+cancionEspañola+"\n--------------------";
    }
}
