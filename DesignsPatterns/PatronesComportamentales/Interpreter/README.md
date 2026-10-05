# Interpreter (Intérprete)

## Propósito

Representa reglas de una gramática como una estructura de objetos y define cómo evaluar esa estructura. Cada expresión interpreta una parte de la gramática.

## Estructura del ejemplo

`Expression` define `interpret(context)`. `NumberExpression` y `Variable` son expresiones simples; `Add` y `Multiply` combinan otras expresiones. `Main` construye el árbol que representa `(x + 2) * 3`.

## Características y uso

- La gramática queda representada explícitamente como árbol.
- Es fácil agregar reglas simples como nuevos tipos de expresión.
- Úsalo para lenguajes pequeños, filtros, reglas o expresiones configurables.
- Para gramáticas grandes o sintaxis compleja, un parser dedicado suele ser más apropiado; el árbol puede crecer rápidamente.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
