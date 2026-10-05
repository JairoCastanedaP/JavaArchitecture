# Visitor (Visitante)

## Propósito

Permite definir operaciones nuevas sobre una estructura de objetos sin añadir esas operaciones a cada clase de elemento. El visitante implementa una operación para cada tipo concreto.

## Estructura del ejemplo

`Shape` declara `accept()`. `Circle` y `Rectangle` llaman el método de visita correspondiente. `AreaVisitor` implementa el cálculo del área para ambos tipos.

## Características y uso

- Agrupa una operación relacionada en un visitante.
- Facilita añadir operaciones cuando la estructura de tipos es estable.
- Usa doble despacho para seleccionar la operación según el visitante y el tipo concreto.
- Agregar un nuevo tipo de elemento obliga a actualizar la interfaz y los visitantes; no es ideal si los tipos cambian con frecuencia.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
