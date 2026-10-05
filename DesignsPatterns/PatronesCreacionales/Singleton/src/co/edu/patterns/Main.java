package co.edu.patterns;

/** Ejecuta el ejemplo Singleton y muestra que ambas referencias apuntan al mismo objeto. */
public class Main {
    public static void main(String[] args) {
        Configuration first = Configuration.getInstance();
        Configuration second = Configuration.getInstance();

        System.out.println("Aplicación: " + first.getApplicationName());
        System.out.println("Primera referencia: " + first);
        System.out.println("Segunda referencia: " + second);
        System.out.println("¿Es la misma instancia?: " + (first == second));
    }
}
