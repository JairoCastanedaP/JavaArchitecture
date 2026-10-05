package co.edu.patterns;

/** Demuestra la creación de nuevos objetos mediante la clonación de un prototipo configurado. */
public class Main {
    static class GameCharacter implements Cloneable {
        private String name;
        private final String classType;
        private String[] abilities;

        GameCharacter(String name, String classType, String... abilities) {
            this.name = name;
            this.classType = classType;
            this.abilities = abilities.clone();
        }

        void setName(String name) { this.name = name; }

        // También se copia el estado mutable para que cambiar una copia no afecte al prototipo.
        @Override
        public GameCharacter clone() {
            try {
                GameCharacter copy = (GameCharacter) super.clone();
                copy.abilities = abilities.clone();
                return copy;
            } catch (CloneNotSupportedException exception) {
                throw new AssertionError("Cloneable debería permitir la clonación", exception);
            }
        }

        @Override
        public String toString() {
            return "GameCharacter{nombre='" + name + "', clase='" + classType
                    + "', habilidades=" + java.util.Arrays.toString(abilities) + "}";
        }
    }

    public static void main(String[] args) {
        GameCharacter template = new GameCharacter("Plantilla", "Explorador", "rastreo", "arquería");
        GameCharacter playerOne = template.clone();
        playerOne.setName("Aria");
        GameCharacter playerTwo = template.clone();
        playerTwo.setName("Borin");

        System.out.println("Prototipo: " + template);
        System.out.println("Primera copia: " + playerOne);
        System.out.println("Segunda copia: " + playerTwo);
        System.out.println("¿Son objetos distintos?: " + (template != playerOne && playerOne != playerTwo));
    }
}
