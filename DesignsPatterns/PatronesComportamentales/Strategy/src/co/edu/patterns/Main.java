package co.edu.patterns;

/** Permite cambiar el algoritmo de pago sin modificar el proceso de compra. */
public class Main {
    interface PaymentStrategy { void pay(double amount); }
    static class CardPayment implements PaymentStrategy {
        public void pay(double amount) { System.out.printf("Pago con tarjeta: $%.2f%n", amount); }
    }
    static class WalletPayment implements PaymentStrategy {
        public void pay(double amount) { System.out.printf("Pago con billetera digital: $%.2f%n", amount); }
    }
    static class Checkout {
        private PaymentStrategy strategy;
        Checkout(PaymentStrategy strategy) { this.strategy = strategy; }
        void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
        void pay(double amount) { strategy.pay(amount); }
    }
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new CardPayment());
        checkout.pay(120.0);
        checkout.setStrategy(new WalletPayment()); checkout.pay(35.5);
    }
}
