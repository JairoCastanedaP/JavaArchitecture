package co.edu.patterns;

/** Define el esqueleto de preparación de una bebida y permite personalizar pasos. */
public class Main {
    static abstract class HotDrink {
        // Este método fija el orden general y delega los pasos variables a subclases.
        final void prepare() { boilWater(); brew(); pour(); addExtras(); }
        private void boilWater() { System.out.println("Hirviendo agua"); }
        abstract void brew();
        private void pour() { System.out.println("Sirviendo en una taza"); }
        void addExtras() { }
    }
    static class Tea extends HotDrink {
        void brew() { System.out.println("Remojando hojas de té"); }
        void addExtras() { System.out.println("Agregando limón"); }
    }
    static class Coffee extends HotDrink {
        void brew() { System.out.println("Filtrando café molido"); }
    }
    public static void main(String[] args) {
        System.out.println("Té:"); new Tea().prepare();
        System.out.println("Café:"); new Coffee().prepare();
    }
}
