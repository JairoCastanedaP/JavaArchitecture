# Patrones comportamentales GoF

Los patrones comportamentales describen cómo colaboran los objetos, distribuyen responsabilidades y comunican decisiones o cambios de estado.

| Patrón | Propósito del ejemplo |
|---|---|
| Chain of Responsibility | Pasa solicitudes por una cadena de responsables. |
| Command | Encapsula una acción ejecutable y reversible. |
| Interpreter | Representa y evalúa una gramática aritmética pequeña. |
| Iterator | Recorre una colección sin exponer su almacenamiento. |
| Mediator | Centraliza mensajes entre usuarios de una sala. |
| Memento | Guarda y restaura el estado de un editor. |
| Observer | Notifica suscriptores ante una noticia. |
| State | Cambia el comportamiento según el estado del semáforo. |
| Strategy | Intercambia algoritmos de pago. |
| Template Method | Fija el orden de preparación de bebidas y permite variar pasos. |
| Visitor | Agrega operaciones a formas sin cambiar sus clases. |

Cada subcarpeta es una aplicación independiente. Desde la carpeta de un patrón:

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
