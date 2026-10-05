package co.edu.patterns;

/** Creador concreto que selecciona el producto SMS. */
public class SmsNotificationCreator extends NotificationCreator {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}
