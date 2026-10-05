package co.edu.patterns;

/** Creador concreto que selecciona el producto de correo electrónico. */
public class EmailNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
