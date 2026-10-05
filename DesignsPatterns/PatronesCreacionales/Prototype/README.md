# Prototype (Prototipo)

## ¿En qué consiste?

Permite crear objetos nuevos copiando una instancia existente, llamada prototipo, en lugar de construirlos desde cero. La copia puede modificarse para representar una variante independiente.

## Estructura del ejemplo

`GameCharacter` implementa `Cloneable` y redefine `clone()`. El método invoca `super.clone()` y duplica también el arreglo mutable `abilities`. `Main` clona una plantilla y asigna nombres diferentes a las copias.

## Características

- La creación parte de un objeto ya configurado.
- Evita repetir lógica de inicialización costosa o compleja.
- Puede ocultar las clases concretas al cliente si se expone una interfaz de prototipo.
- Hay que decidir si la copia será superficial o profunda.

## Modo de uso

Configura una instancia prototipo y solicita una copia mediante `clone()` (o mediante un método de copia explícito). Modifica la copia según se necesite. En este ejemplo cada copia tiene su propio arreglo de habilidades.

## Copia superficial y profunda

Una copia superficial duplica el objeto, pero comparte sus referencias internas mutables. Una copia profunda duplica también esos objetos internos. El ejemplo usa una copia profunda del arreglo para que cambios en una copia no alteren las demás.

## Cuándo puede servir y precauciones

Puede ser conveniente si crear un objeto desde cero es costoso o si se requieren muchas variantes de una configuración base. En Java, `Cloneable` y `Object.clone()` tienen particularidades históricas; en código de producción, a menudo es más explícito implementar un método de copia o un constructor de copia, especialmente cuando el objeto contiene recursos o referencias mutables.

## Ejecutar

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
