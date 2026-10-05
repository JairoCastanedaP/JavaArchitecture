package co.edu.patterns;

/** Simplifica el uso coordinado de varios componentes de cine en casa. */
public class Main {
    static class Projector { void on() { System.out.println("Proyector encendido"); } }
    static class SoundSystem { void on() { System.out.println("Sonido encendido"); } void setSurround() { System.out.println("Sonido envolvente activado"); } }
    static class Player { void play(String movie) { System.out.println("Reproduciendo: " + movie); } }
    static class HomeTheater {
        private final Projector projector = new Projector();
        private final SoundSystem sound = new SoundSystem();
        private final Player player = new Player();
        void watch(String movie) {
            projector.on(); sound.on(); sound.setSurround(); player.play(movie);
        }
    }
    public static void main(String[] args) { new HomeTheater().watch("El viaje"); }
}
