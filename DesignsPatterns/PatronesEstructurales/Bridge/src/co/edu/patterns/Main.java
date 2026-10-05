package co.edu.patterns;

/** Separa la abstracción de control remoto de los dispositivos que controla. */
public class Main {
    interface Device { void turnOn(); void setVolume(int volume); }
    static class Television implements Device {
        public void turnOn() { System.out.println("Televisor encendido"); }
        public void setVolume(int volume) { System.out.println("Volumen del televisor: " + volume); }
    }
    static class Radio implements Device {
        public void turnOn() { System.out.println("Radio encendida"); }
        public void setVolume(int volume) { System.out.println("Volumen de la radio: " + volume); }
    }
    static class RemoteControl {
        protected final Device device;
        RemoteControl(Device device) { this.device = device; }
        void powerOn() { device.turnOn(); }
        void volume(int level) { device.setVolume(level); }
    }
    static class AdvancedRemote extends RemoteControl {
        AdvancedRemote(Device device) { super(device); }
        void mute() { device.setVolume(0); }
    }
    public static void main(String[] args) {
        RemoteControl tvRemote = new RemoteControl(new Television());
        tvRemote.powerOn(); tvRemote.volume(12);
        AdvancedRemote radioRemote = new AdvancedRemote(new Radio());
        radioRemote.powerOn(); radioRemote.mute();
    }
}
