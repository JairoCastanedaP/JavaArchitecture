package co.edu.patterns;

/** Creador: las subclases deciden qué Notification concreta construir. */
public abstract class NotificationCreator {
    protected abstract Notification createNotification();

    // El creador utiliza el producto mediante su interfaz, no mediante su clase concreta.
    public void notify(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
