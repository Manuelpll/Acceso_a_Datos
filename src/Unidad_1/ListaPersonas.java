package Unidad_1;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    private List<Persona> list = new ArrayList<Persona>();
    public ListaPersonas() {}

    public void add(Persona persona) {
        list.add(persona);
    }

    public List<Persona> getList() {
        return list;
    }
}//Fin de ListaPersonas
