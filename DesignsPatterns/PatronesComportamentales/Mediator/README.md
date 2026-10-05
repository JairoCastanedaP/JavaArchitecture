# Mediator (Mediador)

## Propósito

Centraliza la comunicación y coordinación entre objetos colegas. En vez de conocerse y comunicarse directamente entre sí, los participantes envían mensajes al mediador.

## Estructura del ejemplo

`User` envía mensajes mediante `Mediator`. `ChatRoom` implementa el mediador y reenvía el mensaje a los demás usuarios de la sala. Los usuarios no mantienen referencias directas entre ellos.

## Características y uso

- Reduce las dependencias muchos-a-muchos entre colegas.
- Puede coordinar reglas y flujos comunes.
- Úsalo en salas de chat, componentes de interfaz o coordinación de subsistemas.
- El mediador puede volverse demasiado grande; divide responsabilidades cuando acumule demasiadas reglas.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
