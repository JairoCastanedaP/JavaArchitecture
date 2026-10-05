# Command (Comando)

## Propósito

Convierte una solicitud en un objeto que puede almacenarse, encolarse, registrarse o deshacerse. Separa quien inicia la acción de quien la realiza.

## Estructura del ejemplo

`Command` declara `execute()` y `undo()`. `LightOnCommand` enlaza la acción con el receptor `Light`. `Button` es el emisor: ejecuta o deshace el comando sin conocer los detalles de la luz.

## Características y uso

- Permite colas, historial, auditoría y deshacer/rehacer.
- Un comando puede guardar los datos necesarios para ejecutar la acción.
- Úsalo en botones, trabajos diferidos, transacciones o acciones de interfaz.
- Deshacer correctamente puede requerir guardar el estado previo y no siempre es reversible.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
