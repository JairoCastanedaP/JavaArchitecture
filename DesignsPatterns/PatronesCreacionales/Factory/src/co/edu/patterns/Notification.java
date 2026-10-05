package co.edu.patterns;

/** Interfaz de producto: todas las notificaciones ofrecen la misma operación. */
public interface Notification {
    void send(String message);
}
