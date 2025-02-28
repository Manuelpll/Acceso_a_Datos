package Unidad_5.Ejemplo_sencillo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class TemperatureSensor implements Serializable {
    private double temperature;
    private double threshold;
    private PropertyChangeSupport support;

    public TemperatureSensor(double threshold) {
        this.threshold = threshold;
        this.support = new PropertyChangeSupport(this);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double newTemperature) {
        double oldTemperature = this.temperature;
        this.temperature = newTemperature;

        // Notificar a los oyentes sobre cualquier cambio de temperatura
        support.firePropertyChange("temperature", oldTemperature, newTemperature);

        // Disparar evento si se supera el umbral
        if (newTemperature > threshold) {
            System.out.println("⚠️ Alerta: Temperatura sobre el umbral (" + threshold + "°C)");
            support.firePropertyChange("thresholdExceeded", false, true);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
