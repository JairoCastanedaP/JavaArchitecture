package co.edu.patterns;

/** Controla el acceso a una imagen costosa y la carga solo al necesitarla. */
public class Main {
    interface Image { void display(); }
    static class RealImage implements Image {
        private final String file;
        RealImage(String file) { this.file = file; load(); }
        private void load() { System.out.println("Cargando imagen desde disco: " + file); }
        public void display() { System.out.println("Mostrando imagen: " + file); }
    }
    static class ImageProxy implements Image {
        private final String file;
        private RealImage image;
        ImageProxy(String file) { this.file = file; }
        public void display() {
            if (image == null) image = new RealImage(file);
            image.display();
        }
    }
    public static void main(String[] args) {
        Image image = new ImageProxy("paisaje.jpg");
        System.out.println("El proxy se creó sin cargar el archivo.");
        image.display(); image.display();
    }
}
