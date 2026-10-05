package co.edu.patterns;

/** Cambia el comportamiento del semáforo según su estado actual. */
public class Main {
    interface TrafficState { void next(TrafficLight light); String color(); }
    static class Red implements TrafficState {
        public void next(TrafficLight light) { light.setState(new Green()); }
        public String color() { return "rojo"; }
    }
    static class Green implements TrafficState {
        public void next(TrafficLight light) { light.setState(new Yellow()); }
        public String color() { return "verde"; }
    }
    static class Yellow implements TrafficState {
        public void next(TrafficLight light) { light.setState(new Red()); }
        public String color() { return "amarillo"; }
    }
    static class TrafficLight {
        private TrafficState state = new Red();
        void setState(TrafficState state) { this.state = state; }
        void advance() { state.next(this); }
        void show() { System.out.println("Semáforo: " + state.color()); }
    }
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 4; i++) { light.show(); light.advance(); }
    }
}
