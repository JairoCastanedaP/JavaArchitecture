package co.edu.patterns;

/** Añade responsabilidades a una bebida envolviendo el objeto original. */
public class Main {
    interface Coffee { String description(); double cost(); }
    static class SimpleCoffee implements Coffee {
        public String description() { return "café"; }
        public double cost() { return 2.0; }
    }
    static abstract class AddOn implements Coffee {
        protected final Coffee coffee;
        AddOn(Coffee coffee) { this.coffee = coffee; }
    }
    static class Milk extends AddOn {
        Milk(Coffee coffee) { super(coffee); }
        public String description() { return coffee.description() + " con leche"; }
        public double cost() { return coffee.cost() + 0.5; }
    }
    static class Caramel extends AddOn {
        Caramel(Coffee coffee) { super(coffee); }
        public String description() { return coffee.description() + " con caramelo"; }
        public double cost() { return coffee.cost() + 0.7; }
    }
    public static void main(String[] args) {
        Coffee order = new Caramel(new Milk(new SimpleCoffee()));
        System.out.printf("%s: $%.2f%n", order.description(), order.cost());
    }
}
