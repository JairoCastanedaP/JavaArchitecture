package co.edu.patterns;

/** Otro producto concreto que envía un mensaje por SMS. */
public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
