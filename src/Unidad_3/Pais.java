package Unidad_3;

public class Pais {
    private int idPais;
    private String nombrePais;

    public Pais() {};

    public Pais(int id, String nombre) {
        super();
        idPais = id;
        nombrePais = nombre;
    }

    //GETTERS Y SETTERS
    public int getIdPais() {
        return idPais;
    }
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    public String toString() { return nombrePais; }
}
