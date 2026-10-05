package co.edu.patterns;

/** Configuración única, creada de forma diferida y segura para varios hilos. */
public final class Configuration {
    private final String applicationName = "Ejemplos de patrones de diseño";

    private Configuration() {
        System.out.println("Creando la configuración compartida...");
    }

    // La JVM inicializa esta clase anidada solo cuando se invoca getInstance() por primera vez.
    private static class Holder {
        private static final Configuration INSTANCE = new Configuration();
    }

    public static Configuration getInstance() {
        return Holder.INSTANCE;
    }

    public String getApplicationName() {
        return applicationName;
    }
}
