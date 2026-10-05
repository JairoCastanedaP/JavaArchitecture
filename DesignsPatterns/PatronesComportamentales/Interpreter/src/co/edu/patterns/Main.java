package co.edu.patterns;

import java.util.Map;

/** Representa y evalúa una gramática aritmética pequeña mediante objetos. */
public class Main {
    interface Expression { int interpret(Map<String, Integer> context); }
    static class NumberExpression implements Expression {
        private final int value;
        NumberExpression(int value) { this.value = value; }
        public int interpret(Map<String, Integer> context) { return value; }
    }
    static class Variable implements Expression {
        private final String name;
        Variable(String name) { this.name = name; }
        public int interpret(Map<String, Integer> context) {
            if (!context.containsKey(name)) throw new IllegalArgumentException("Variable sin valor: " + name);
            return context.get(name);
        }
    }
    static class Add implements Expression {
        private final Expression left, right;
        Add(Expression left, Expression right) { this.left = left; this.right = right; }
        public int interpret(Map<String, Integer> c) { return left.interpret(c) + right.interpret(c); }
    }
    static class Multiply implements Expression {
        private final Expression left, right;
        Multiply(Expression left, Expression right) { this.left = left; this.right = right; }
        public int interpret(Map<String, Integer> c) { return left.interpret(c) * right.interpret(c); }
    }
    public static void main(String[] args) {
        Expression expression = new Multiply(new Add(new Variable("x"), new NumberExpression(2)), new NumberExpression(3));
        System.out.println("(x + 2) * 3 con x = 4 da: " + expression.interpret(Map.of("x", 4)));
    }
}
