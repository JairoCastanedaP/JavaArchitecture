# Iterator (Iterador)

## Propósito

Permite recorrer los elementos de una colección de forma secuencial sin exponer cómo se almacenan internamente.

## Estructura del ejemplo

`Playlist` contiene una lista privada de canciones e implementa `Iterable<String>`. Su método `iterator()` entrega el iterador de la colección. El ciclo mejorado de `Main` recorre la lista sin acceder a la lista interna.

## Características y uso

- Separa el recorrido de la estructura de datos.
- En Java, `Iterator` e `Iterable` ofrecen soporte estándar para este patrón.
- Úsalo para proveer diferentes órdenes de recorrido o abstraer colecciones.
- Define qué ocurre si la colección cambia mientras se recorre.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
