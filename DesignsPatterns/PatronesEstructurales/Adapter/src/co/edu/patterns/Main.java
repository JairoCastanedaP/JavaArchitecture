package co.edu.patterns;

/** Adapta una interfaz existente a la que espera el cliente. */
public class Main {
    interface TemperatureService { double temperatureCelsius(); }
    static class LegacySensor {
        double readFahrenheit() { return 68.0; }
    }
    static class SensorAdapter implements TemperatureService {
        private final LegacySensor sensor;
        SensorAdapter(LegacySensor sensor) { this.sensor = sensor; }
        public double temperatureCelsius() {
            return (sensor.readFahrenheit() - 32) * 5 / 9;
        }
    }
    public static void main(String[] args) {
        TemperatureService service = new SensorAdapter(new LegacySensor());
        System.out.printf("Temperatura adaptada: %.1f °C%n", service.temperatureCelsius());
    }
}
