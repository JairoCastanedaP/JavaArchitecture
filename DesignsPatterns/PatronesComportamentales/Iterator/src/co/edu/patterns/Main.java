package co.edu.patterns;

import java.util.ArrayList;
import java.util.List;

/** Recorre una colección sin exponer cómo está almacenada internamente. */
public class Main {
    static class Playlist implements Iterable<String> {
        private final List<String> songs = new ArrayList<>();
        void add(String song) { songs.add(song); }
        public java.util.Iterator<String> iterator() { return songs.iterator(); }
    }
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add("Luz de luna"); playlist.add("Camino al mar"); playlist.add("Regreso");
        for (String song : playlist) System.out.println("Canción: " + song);
    }
}
