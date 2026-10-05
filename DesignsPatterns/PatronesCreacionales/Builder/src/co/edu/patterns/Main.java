package co.edu.patterns;

/** Demuestra cómo construir un objeto inmutable con opciones configurables. */
public class Main {
    static class Computer {
        private final String processor;
        private final int memoryGb;
        private final boolean dedicatedGraphics;

        private Computer(Builder builder) {
            this.processor = builder.processor;
            this.memoryGb = builder.memoryGb;
            this.dedicatedGraphics = builder.dedicatedGraphics;
        }

        @Override
        public String toString() {
            return "Computer{procesador='" + processor + "', memoriaGb=" + memoryGb
                    + ", graficosDedicados=" + dedicatedGraphics + "}";
        }

        // Builder reúne los valores obligatorios y opcionales antes de crear el producto.
        static class Builder {
            private final String processor;
            private int memoryGb = 8;
            private boolean dedicatedGraphics;

            Builder(String processor) {
                if (processor == null || processor.trim().isEmpty()) {
                    throw new IllegalArgumentException("El procesador es obligatorio");
                }
                this.processor = processor;
            }

            Builder memoryGb(int memoryGb) {
                if (memoryGb < 1) throw new IllegalArgumentException("La memoria debe ser positiva");
                this.memoryGb = memoryGb;
                return this;
            }

            Builder dedicatedGraphics(boolean enabled) {
                this.dedicatedGraphics = enabled;
                return this;
            }

            Computer build() { return new Computer(this); }
        }
    }

    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder("Intel Core i5").build();
        Computer designComputer = new Computer.Builder("AMD Ryzen 9")
                .memoryGb(32)
                .dedicatedGraphics(true)
                .build();

        System.out.println("Configuración predeterminada: " + officeComputer);
        System.out.println("Configuración personalizada:  " + designComputer);
    }
}
