# Facade (Fachada)

## Propósito

Proporciona una interfaz sencilla y de alto nivel frente a un subsistema con varios componentes. La fachada coordina la secuencia de operaciones que el cliente tendría que realizar manualmente.

## Estructura del ejemplo

`Projector`, `SoundSystem` y `Player` componen el subsistema. `HomeTheater.watch()` los enciende, configura el sonido y reproduce una película en una sola llamada.

## Características y uso

- Reduce el conocimiento que el cliente necesita del subsistema.
- No impide que otros clientes usen directamente los componentes cuando sea necesario.
- Úsala para simplificar bibliotecas complejas o delimitar una capa de aplicación.
- Evita convertirla en una clase enorme que concentre responsabilidades no relacionadas.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
