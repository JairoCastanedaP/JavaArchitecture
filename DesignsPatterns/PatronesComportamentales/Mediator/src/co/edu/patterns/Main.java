package co.edu.patterns;

import java.util.ArrayList;
import java.util.List;

/** Centraliza la comunicación entre participantes de una sala de chat. */
public class Main {
    interface Mediator { void send(String message, User sender); }
    static class ChatRoom implements Mediator {
        private final List<User> users = new ArrayList<>();
        void join(User user) { users.add(user); }
        public void send(String message, User sender) {
            for (User user : users) if (user != sender) user.receive(sender.name + ": " + message);
        }
    }
    static class User {
        final String name; private final Mediator mediator;
        User(String name, Mediator mediator) { this.name = name; this.mediator = mediator; }
        void send(String message) { mediator.send(message, this); }
        void receive(String message) { System.out.println(name + " recibe → " + message); }
    }
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        User ana = new User("Ana", room), leo = new User("Leo", room), sol = new User("Sol", room);
        room.join(ana); room.join(leo); room.join(sol);
        ana.send("¡Hola a todos!");
    }
}
