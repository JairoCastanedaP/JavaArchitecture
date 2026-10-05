# Abstract Factory (Fábrica abstracta)

## ¿En qué consiste?

Proporciona una interfaz para crear familias de objetos relacionados sin acoplar al cliente a sus clases concretas. Una fábrica concreta produce todos los elementos de una familia compatible.

## Estructura del ejemplo

`UiFactory` declara métodos para crear `Button` y `Checkbox`. `LightThemeFactory` crea componentes claros y `DarkThemeFactory` componentes oscuros. El método `renderWindow()` recibe cualquier fábrica y usa sus productos mediante interfaces.

## Características

- Agrupa métodos de creación de distintos tipos de productos.
- Mantiene la compatibilidad entre productos de una misma familia.
- Permite cambiar una familia completa sustituyendo la fábrica.
- El cliente depende de interfaces, no de las clases concretas.

## Modo de uso

Elige la fábrica de una familia (por ejemplo, tema claro), pásala al cliente y solicita cada producto. La misma estructura puede ampliarse con otra familia de fábrica que implemente los mismos métodos.

## Cuándo puede servir y precauciones

Resulta útil cuando la aplicación necesita varias familias coherentes, como temas visuales, productos por plataforma o proveedores intercambiables. Agregar una nueva familia suele ser sencillo. Agregar un nuevo tipo de producto implica cambiar la interfaz y cada fábrica concreta, por lo que conviene usarlo cuando las familias de productos están relativamente definidas.

## Diferencia con Factory Method

Factory Method delega la creación de un producto, normalmente mediante subclases de creador. Abstract Factory ofrece un conjunto de métodos para crear varios productos relacionados como una familia.

## Ejecutar

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
