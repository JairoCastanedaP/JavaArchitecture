package co.edu.patterns;

/** Producto concreto que envía un mensaje por correo electrónico. */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando correo electrónico: " + message);
    }
}
