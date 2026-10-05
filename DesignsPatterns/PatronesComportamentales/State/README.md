# State (Estado)

## Propósito

Permite que un objeto cambie su comportamiento cuando cambia su estado interno. Cada estado representa sus propias reglas y transiciones, evitando condicionales extensos en el contexto.

## Estructura del ejemplo

`TrafficLight` es el contexto. `Red`, `Green` y `Yellow` implementan `TrafficState`, muestran un color y deciden el siguiente estado. El contexto delega la transición al estado actual.

## Características y uso

- Encapsula comportamiento y transiciones por estado.
- Hace explícitas las transiciones válidas.
- Úsalo en flujos de pedido, conexiones, protocolos o máquinas de estado.
- Si solo hay dos estados simples, una jerarquía puede ser más compleja que una condición directa.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
