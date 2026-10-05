package co.edu.patterns;

/** Encapsula acciones como objetos que pueden ejecutarse o deshacerse. */
public class Main {
    interface Command { void execute(); void undo(); }
    static class Light {
        void on() { System.out.println("Luz encendida"); }
        void off() { System.out.println("Luz apagada"); }
    }
    static class LightOnCommand implements Command {
        private final Light light;
        LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.on(); }
        public void undo() { light.off(); }
    }
    static class Button {
        private final Command command;
        Button(Command command) { this.command = command; }
        void press() { command.execute(); }
        void undo() { command.undo(); }
    }
    public static void main(String[] args) {
        Button button = new Button(new LightOnCommand(new Light()));
        button.press(); button.undo();
    }
}
