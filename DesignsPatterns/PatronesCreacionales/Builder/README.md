# Builder (construcción paso a paso)

## ¿En qué consiste?

Separa la construcción de un objeto complejo de su representación final. El objeto se configura paso a paso y solo se crea cuando se llama a `build()`.

## Estructura del ejemplo

`Computer` es el producto. Su constructor recibe un `Builder` y copia sus valores. `Computer.Builder` exige un procesador, ofrece valores opcionales con valores predeterminados y devuelve el constructor en cada método para permitir llamadas encadenadas.

## Características

- Hace legible la configuración de objetos con varios parámetros.
- Evita constructores con muchos argumentos posicionales.
- Permite expresar valores obligatorios, opcionales y predeterminados.
- Facilita validar los datos antes de crear el objeto.
- Puede producir objetos inmutables.

## Modo de uso

Se crea el builder con los datos obligatorios, se encadenan las opciones necesarias y se termina con `build()`. El ejemplo muestra una computadora con valores predeterminados y otra configurada con más memoria y gráficos dedicados.

## Cuándo puede servir y precauciones

Es útil cuando la construcción tiene varias opciones o pasos, o cuando existen muchas combinaciones válidas. Para un objeto pequeño con uno o dos valores, un constructor sencillo puede ser más claro. Un builder puede validar tanto cada opción como el conjunto completo al construir.

## Ejecutar

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
