# Observer (Observador)

## Propósito

Define una relación uno-a-muchos: cuando el sujeto cambia o publica un evento, notifica a sus observadores suscritos.

## Estructura del ejemplo

`NewsAgency` mantiene la lista de observadores y los notifica al publicar un titular. `Subscriber` implementa `Observer` y reacciona a la actualización.

## Características y uso

- Permite suscribir y notificar participantes sin acoplar el sujeto a clases concretas.
- Se usa en eventos, interfaces reactivas y notificaciones.
- Conviene definir cómo suscribirse y darse de baja, así como el orden y manejo de errores.
- Suscripciones olvidadas pueden retener objetos; administra el ciclo de vida de los observadores.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
