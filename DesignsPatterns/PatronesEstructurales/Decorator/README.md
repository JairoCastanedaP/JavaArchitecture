# Decorator (Decorador)

## Propósito

Agrega responsabilidades a un objeto dinámicamente envolviéndolo en otro objeto que implementa la misma interfaz. Es una alternativa flexible a crear subclases para cada combinación.

## Estructura del ejemplo

`Coffee` define descripción y costo. `SimpleCoffee` es el objeto base. `Milk` y `Caramel` son decoradores que guardan una bebida envuelta y añaden descripción y precio.

## Características y uso

- Los decoradores se pueden combinar y apilar.
- Mantienen la interfaz del objeto decorado.
- Úsalo para opciones combinables, middleware, flujos de entrada/salida o mejoras visuales.
- Muchos envoltorios pueden dificultar depuración e inspección; el orden puede cambiar el resultado.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
