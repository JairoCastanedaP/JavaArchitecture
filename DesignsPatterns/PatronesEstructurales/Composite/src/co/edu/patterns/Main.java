package co.edu.patterns;

import java.util.ArrayList;
import java.util.List;

/** Trata archivos y carpetas mediante una misma interfaz. */
public class Main {
    interface Entry { void show(String indent); }
    static class FileEntry implements Entry {
        private final String name;
        FileEntry(String name) { this.name = name; }
        public void show(String indent) { System.out.println(indent + "- " + name); }
    }
    static class Folder implements Entry {
        private final String name;
        private final List<Entry> children = new ArrayList<>();
        Folder(String name) { this.name = name; }
        Folder add(Entry entry) { children.add(entry); return this; }
        public void show(String indent) {
            System.out.println(indent + "+ " + name);
            for (Entry child : children) child.show(indent + "  ");
        }
    }
    public static void main(String[] args) {
        Folder root = new Folder("Documentos");
        root.add(new FileEntry("notas.txt"));
        root.add(new Folder("Java").add(new FileEntry("Main.java")).add(new FileEntry("README.md")));
        root.show("");
    }
}
