# Proxy (Proxy o sustituto)

## Propósito

Proporciona un objeto sustituto que conserva la interfaz del objeto real y controla el acceso a él. Puede añadir carga diferida, control de acceso, registro o comunicación remota.

## Estructura del ejemplo

`Image` define la interfaz común. `RealImage` carga el archivo al construirse. `ImageProxy` conserva el nombre del archivo y crea `RealImage` solamente en la primera llamada a `display()`; las siguientes reutilizan la instancia.

## Características y uso

- El cliente trabaja con el mismo contrato, tenga proxy u objeto real.
- Permite diferir o controlar operaciones costosas.
- Úsalo para carga diferida, permisos, caché o acceso remoto.
- Un proxy añade indirección y puede ocultar latencia o errores; no debe fingir que operaciones remotas son locales y gratuitas.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
