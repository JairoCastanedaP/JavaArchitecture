package co.edu.patterns;

import java.util.ArrayList;
import java.util.List;

/** Notifica a suscriptores cuando cambia el estado del editor de noticias. */
public class Main {
    interface Observer { void update(String headline); }
    static class Subscriber implements Observer {
        private final String name;
        Subscriber(String name) { this.name = name; }
        public void update(String headline) { System.out.println(name + " recibió: " + headline); }
    }
    static class NewsAgency {
        private final List<Observer> observers = new ArrayList<>();
        void subscribe(Observer observer) { observers.add(observer); }
        void publish(String headline) {
            for (Observer observer : observers) observer.update(headline);
        }
    }
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.subscribe(new Subscriber("Alicia")); agency.subscribe(new Subscriber("Bruno"));
        agency.publish("Se inaugura la biblioteca del barrio");
    }
}
