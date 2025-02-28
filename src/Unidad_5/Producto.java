package Unidad_5;

import java.beans.*;
import java.io.Serializable;

public class Producto implements Serializable {
    private String descripcion;
    private int idproducto;
    private int stockactual;
    private int stockminimo;
    private float pvp;
    private boolean disponible; // Nuevo estado para "descontinuado"
    private final PropertyChangeSupport support;

    public Producto() {
        this.support = new PropertyChangeSupport(this);
        this.disponible = true;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldValue = this.descripcion;
        this.descripcion = descripcion;
        support.firePropertyChange("descripcion", oldValue, descripcion);
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        float oldValue = this.pvp;
        this.pvp = pvp;
        support.firePropertyChange("pvp", oldValue, pvp);
    }

    public int getStockactual() {
        return stockactual;
    }

    public void setStockactual(int stockactual) {
        int oldValue = this.stockactual;
        this.stockactual = stockactual;
        support.firePropertyChange("stockactual", oldValue, stockactual);

        // 📉 Evento de stock crítico (cuando llega a 0)
        if (stockactual == 0) {
            System.out.println("⚠️ ¡Stock agotado para el producto " + descripcion + "!");
            support.firePropertyChange("stockCritico", false, true);
        }

        // 📦 Evento de reposición de stock
        if (oldValue < stockactual) {
            System.out.println("📦 Se ha recibido nuevo stock de " + descripcion);
            support.firePropertyChange("reposicionStock", oldValue, stockactual);
        }
    }

    public int getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(int stockminimo) {
        int oldValue = this.stockminimo;
        this.stockminimo = stockminimo;
        support.firePropertyChange("stockminimo", oldValue, stockminimo);
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        int oldValue = this.idproducto;
        this.idproducto = idproducto;
        support.firePropertyChange("idproducto", oldValue, idproducto);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        boolean oldValue = this.disponible;
        this.disponible = disponible;
        support.firePropertyChange("disponible", oldValue, disponible);
        if (!disponible) {
            System.out.println("❌ El producto " + descripcion + " ha sido descontinuado.");
        }
    }

    // Métodos para agregar y eliminar listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
