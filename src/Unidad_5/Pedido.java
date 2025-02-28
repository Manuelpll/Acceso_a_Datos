package Unidad_5;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable, PropertyChangeListener {
    private int numeropedido;
    private int idproducto;
    private Date fecha;
    private int cantidad;
    private boolean pedir;
    private boolean enEspera; // Nuevo estado
    private final PropertyChangeSupport support;

    public Pedido() {
        this.support = new PropertyChangeSupport(this);
        this.enEspera = false;
    }
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("⚡ Evento detectado en Pedido: " + evt.getPropertyName() +
                " | Valor anterior: " + evt.getOldValue() +
                " | Nuevo valor: " + evt.getNewValue());

        // 📉 Si el stock es crítico, el pedido se pone en espera
        if ("stockCritico".equals(evt.getPropertyName())) {
            System.out.println("⏳ Pedido en espera debido a falta de stock.");
            this.enEspera = true;
            support.firePropertyChange("pedidoEnEspera", false, true);
        }

        // 📦 Si hay reposición de stock, se reactiva el pedido
        if ("reposicionStock".equals(evt.getPropertyName())) {
            if (this.enEspera) {
                System.out.println("✅ Stock disponible, procesando el pedido.");
                this.enEspera = false;
                support.firePropertyChange("pedidoProcesado", true, false);
            }
        }

        // ❌ Si el producto es descontinuado, el pedido se cancela
        if ("disponible".equals(evt.getPropertyName()) && !(boolean) evt.getNewValue()) {
            System.out.println("🚫 Pedido cancelado porque el producto ha sido descontinuado.");
            support.firePropertyChange("pedidoCancelado", false, true);
        }
    }
}

