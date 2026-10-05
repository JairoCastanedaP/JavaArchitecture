package co.edu.patterns;

/** Agrega operaciones a formas geométricas mediante visitantes. */
public class Main {
    interface Shape { void accept(Visitor visitor); }
    static class Circle implements Shape {
        final double radius;
        Circle(double radius) { this.radius = radius; }
        public void accept(Visitor visitor) { visitor.visit(this); }
    }
    static class Rectangle implements Shape {
        final double width, height;
        Rectangle(double width, double height) { this.width = width; this.height = height; }
        public void accept(Visitor visitor) { visitor.visit(this); }
    }
    interface Visitor { void visit(Circle circle); void visit(Rectangle rectangle); }
    static class AreaVisitor implements Visitor {
        public void visit(Circle circle) { System.out.printf("Área del círculo: %.2f%n", Math.PI * circle.radius * circle.radius); }
        public void visit(Rectangle rectangle) { System.out.printf("Área del rectángulo: %.2f%n", rectangle.width * rectangle.height); }
    }
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4) };
        Visitor area = new AreaVisitor();
        for (Shape shape : shapes) shape.accept(area);
    }
}
