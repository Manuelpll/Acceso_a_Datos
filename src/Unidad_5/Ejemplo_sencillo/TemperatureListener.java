package Unidad_5.Ejemplo_sencillo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("temperature".equals(evt.getPropertyName())) {
            System.out.println("🔄 Temperatura actualizada: " + evt.getNewValue() + "°C");
        } else if ("thresholdExceeded".equals(evt.getPropertyName())) {
            System.out.println("🚨 ¡Alerta! La temperatura ha superado el umbral.");
        }
    }
}

