package co.edu.patterns;

import java.util.HashMap;
import java.util.Map;

/** Comparte datos intrínsecos entre muchos árboles para ahorrar memoria. */
public class Main {
    static class TreeType {
        final String species; final String color;
        TreeType(String species, String color) { this.species = species; this.color = color; }
        void draw(int x, int y) { System.out.println(species + " " + color + " en (" + x + ", " + y + ")"); }
    }
    static class TreeTypeFactory {
        private static final Map<String, TreeType> types = new HashMap<>();
        static TreeType get(String species, String color) {
            String key = species + ":" + color;
            if (!types.containsKey(key)) types.put(key, new TreeType(species, color));
            return types.get(key);
        }
        static int count() { return types.size(); }
    }
    static class Tree {
        final int x, y; final TreeType type;
        Tree(int x, int y, TreeType type) { this.x = x; this.y = y; this.type = type; }
        void draw() { type.draw(x, y); }
    }
    public static void main(String[] args) {
        Tree a = new Tree(2, 5, TreeTypeFactory.get("Roble", "verde"));
        Tree b = new Tree(8, 3, TreeTypeFactory.get("Roble", "verde"));
        a.draw(); b.draw();
        System.out.println("Tipos compartidos almacenados: " + TreeTypeFactory.count());
        System.out.println("Comparten el tipo: " + (a.type == b.type));
    }
}
