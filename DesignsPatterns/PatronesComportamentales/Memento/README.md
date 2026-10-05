# Memento (Recuerdo)

## Propósito

Captura y permite restaurar el estado interno de un objeto sin exponer su representación. Es útil para guardar puntos de recuperación.

## Estructura del ejemplo

`Editor` es el originador: crea una instantánea y puede restaurarla. `Snapshot` guarda el texto y es privada dentro del editor, de modo que el cliente conserva el memento sin manipular los detalles internos.

## Características y uso

- Conserva el encapsulamiento del originador.
- Permite puntos de guardado, deshacer o recuperación.
- Úsalo cuando sea necesario restaurar estados anteriores.
- Las instantáneas pueden consumir mucha memoria; considera historial limitado o copias diferenciales.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
