# Composite (Compuesto)

## Propósito

Organiza objetos en estructuras de árbol y permite tratar de forma uniforme un elemento individual y un grupo de elementos.

## Estructura del ejemplo

`Entry` es el componente común. `FileEntry` es una hoja y `Folder` es un compuesto que contiene otros `Entry`. Ambos exponen `show()`, y una carpeta delega el recorrido a sus hijos.

## Características y uso

- Representa jerarquías parte-todo de profundidad variable.
- Simplifica el cliente, que opera sobre la interfaz común.
- Úsalo en árboles de archivos, menús, componentes gráficos o expresiones.
- Algunas operaciones solo tienen sentido para hojas o compuestos; diseña la interfaz teniendo presente esa diferencia.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
