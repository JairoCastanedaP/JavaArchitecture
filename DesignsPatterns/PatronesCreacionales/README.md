# Patrones creacionales GoF

Los patrones creacionales organizan la creación de objetos. Ayudan a reducir el acoplamiento entre el código cliente y las clases concretas, y permiten controlar cómo, cuándo y con qué configuración se construyen los objetos.

| Carpeta | Patrón | Pregunta que ayuda a responder |
|---|---|---|
| `Singleton` | Singleton | ¿Cómo se garantiza una única instancia compartida? |
| `Factory` | Factory Method | ¿Cómo delegar en subclases la elección del producto concreto? |
| `AbstractFactory` | Abstract Factory | ¿Cómo crear familias de productos relacionados? |
| `Builder` | Builder | ¿Cómo construir objetos complejos paso a paso? |
| `Prototype` | Prototype | ¿Cómo crear objetos nuevos a partir de una instancia existente? |

Cada proyecto solo requiere el JDK. Desde la carpeta de un patrón, compila y ejecuta así:

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```

Los nombres de clases y métodos permanecen en inglés para practicar el lenguaje; las explicaciones, comentarios y mensajes se presentan en español.
