package co.edu.patterns;

/** Guarda y restaura el estado de un editor sin exponer sus detalles internos. */
public class Main {
    static class Editor {
        private String text = "";
        void write(String text) { this.text = text; }
        Snapshot save() { return new Snapshot(text); }
        void restore(Snapshot snapshot) { text = snapshot.text; }
        void show() { System.out.println("Texto actual: " + text); }
        private static class Snapshot {
            private final String text;
            private Snapshot(String text) { this.text = text; }
        }
    }
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.write("Borrador inicial");
        Editor.Snapshot checkpoint = editor.save();
        editor.write("Texto modificado por error"); editor.show();
        editor.restore(checkpoint); editor.show();
    }
}
