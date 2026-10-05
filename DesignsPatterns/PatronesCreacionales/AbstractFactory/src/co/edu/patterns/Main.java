package co.edu.patterns;

/** Demuestra la creación de componentes de interfaz compatibles mediante Abstract Factory. */
public class Main {
    interface Button { void render(); }
    interface Checkbox { void render(); }

    interface UiFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    static class LightButton implements Button {
        public void render() { System.out.println("Dibujando un botón de tema claro"); }
    }
    static class LightCheckbox implements Checkbox {
        public void render() { System.out.println("Dibujando una casilla de tema claro"); }
    }
    static class DarkButton implements Button {
        public void render() { System.out.println("Dibujando un botón de tema oscuro"); }
    }
    static class DarkCheckbox implements Checkbox {
        public void render() { System.out.println("Dibujando una casilla de tema oscuro"); }
    }

    // Cada fábrica concreta crea una familia coherente de productos relacionados.
    static class LightThemeFactory implements UiFactory {
        public Button createButton() { return new LightButton(); }
        public Checkbox createCheckbox() { return new LightCheckbox(); }
    }
    static class DarkThemeFactory implements UiFactory {
        public Button createButton() { return new DarkButton(); }
        public Checkbox createCheckbox() { return new DarkCheckbox(); }
    }

    // El cliente depende de interfaces y puede cambiar fácilmente de familia de productos.
    private static void renderWindow(UiFactory factory) {
        factory.createButton().render();
        factory.createCheckbox().render();
    }

    public static void main(String[] args) {
        System.out.println("Tema claro:");
        renderWindow(new LightThemeFactory());
        System.out.println("Tema oscuro:");
        renderWindow(new DarkThemeFactory());
    }
}
