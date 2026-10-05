package co.edu.patterns;

/** Ejecuta dos variantes de creador para mostrar Factory Method. */
public class Main {
    public static void main(String[] args) {
        NotificationCreator emailCreator = new EmailNotificationCreator();
        NotificationCreator smsCreator = new SmsNotificationCreator();

        emailCreator.notify("Tu pedido ha sido enviado.");
        smsCreator.notify("Tu código de verificación es 4821.");
    }
}
