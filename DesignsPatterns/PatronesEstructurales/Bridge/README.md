# Bridge (Puente)

## Propósito

Separa una abstracción de su implementación para que ambas puedan evolucionar independientemente. En lugar de crear una subclase por cada combinación, la abstracción mantiene una referencia a un implementador.

## Estructura del ejemplo

`RemoteControl` es la abstracción y delega acciones a `Device`. `Television` y `Radio` implementan el dispositivo. `AdvancedRemote` extiende la abstracción con la función de silenciar.

## Características y uso

- Combina jerarquías independientes mediante composición.
- Facilita agregar tipos de controles o dispositivos sin multiplicar combinaciones de subclases.
- Úsalo cuando dos dimensiones de variación deban cambiar por separado.
- Añade una capa de indirección; no hace falta para estructuras simples y estables.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
