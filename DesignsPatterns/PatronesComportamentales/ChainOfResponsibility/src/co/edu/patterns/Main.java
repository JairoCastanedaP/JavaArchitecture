package co.edu.patterns;

/** Pasa una solicitud por manejadores hasta encontrar quien pueda resolverla. */
public class Main {
    static abstract class SupportHandler {
        private SupportHandler next;
        SupportHandler setNext(SupportHandler next) { this.next = next; return next; }
        void handle(String issue) {
            if (canHandle(issue)) resolve(issue);
            else if (next != null) next.handle(issue);
            else System.out.println("No se encontró un responsable para: " + issue);
        }
        abstract boolean canHandle(String issue);
        abstract void resolve(String issue);
    }
    static class HelpDesk extends SupportHandler {
        boolean canHandle(String issue) { return issue.equals("contraseña"); }
        void resolve(String issue) { System.out.println("Mesa de ayuda resuelve: " + issue); }
    }
    static class Technician extends SupportHandler {
        boolean canHandle(String issue) { return issue.equals("red"); }
        void resolve(String issue) { System.out.println("Técnico resuelve: " + issue); }
    }
    static class Manager extends SupportHandler {
        boolean canHandle(String issue) { return true; }
        void resolve(String issue) { System.out.println("Gerencia revisa: " + issue); }
    }
    public static void main(String[] args) {
        SupportHandler first = new HelpDesk();
        first.setNext(new Technician()).setNext(new Manager());
        first.handle("contraseña"); first.handle("red"); first.handle("reembolso");
    }
}
