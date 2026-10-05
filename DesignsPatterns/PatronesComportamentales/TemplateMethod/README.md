# Template Method (Método plantilla)

## Propósito

Define en una clase base el esqueleto de un algoritmo, dejando que las subclases redefinan ciertos pasos sin alterar el orden general.

## Estructura del ejemplo

`HotDrink.prepare()` establece los pasos comunes: hervir, preparar, servir y agregar extras. `Tea` y `Coffee` implementan la preparación particular; el té también personaliza el paso opcional de extras.

## Características y uso

- Reutiliza el flujo común y delega variaciones puntuales.
- El método plantilla puede declararse `final` para preservar el orden.
- Úsalo cuando varias implementaciones compartan el algoritmo general.
- La herencia fija una relación; si se necesita cambiar pasos libremente en ejecución, Strategy puede encajar mejor.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
