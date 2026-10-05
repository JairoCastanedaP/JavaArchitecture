# Singleton

## ¿En qué consiste?

Singleton garantiza que una clase tenga una sola instancia y ofrece un punto conocido para acceder a ella. Todas las partes del programa que solicitan el objeto reciben la misma instancia.

## Estructura del ejemplo

`Configuration` tiene constructor privado, por lo que otras clases no pueden crearla con `new`. `getInstance()` expone la instancia compartida. La clase anidada `Holder` hace que la instancia se cree de forma diferida y que la inicialización sea segura entre hilos gracias a las garantías de inicialización de clases de Java.

## Características

- Control centralizado de la creación.
- Acceso global mediante un método estático.
- Creación diferida: ocurre al solicitarla por primera vez.
- La implementación del ejemplo es segura para varios hilos.

## Modo de uso

Llama a `Configuration.getInstance()` desde cualquier parte del programa. En `Main`, dos llamadas producen referencias que apuntan al mismo objeto; la salida lo demuestra comparándolas con `==`.

## Cuándo puede servir y precauciones

Puede ser útil para un recurso que realmente deba compartirse, como una configuración inmutable. Sin embargo, añade estado global y hace más difícil sustituir dependencias en pruebas. No debe usarse solo para evitar pasar objetos entre componentes. En aplicaciones Spring, normalmente se prefiere que el contenedor administre el ciclo de vida; el alcance singleton predeterminado de un bean no requiere implementar este patrón manualmente.

## Ejecutar

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
