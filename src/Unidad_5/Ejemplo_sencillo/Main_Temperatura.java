package Unidad_5.Ejemplo_sencillo;

public class Main_Temperatura {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor(30.0); // Umbral de 30°C
        TemperatureListener listener = new TemperatureListener();

        // Registrar el listener
        sensor.addPropertyChangeListener(listener);

        // Simular cambios de temperatura
        sensor.setTemperature(25.0);
        sensor.setTemperature(28.5);
        sensor.setTemperature(31.2); // Supera el umbral
        sensor.setTemperature(29.0);
    }
}