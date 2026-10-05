# Patrones estructurales GoF

Los patrones estructurales describen cómo componer clases y objetos para formar estructuras mayores, conservando flexibilidad y reduciendo el acoplamiento.

| Patrón | Propósito del ejemplo |
|---|---|
| Adapter | Convierte la interfaz de un sensor legado a la interfaz esperada. |
| Bridge | Desacopla controles de los dispositivos que operan. |
| Composite | Trata archivos y carpetas de manera uniforme. |
| Decorator | Agrega complementos y costo a una bebida envolviendo objetos. |
| Facade | Ofrece una operación sencilla para coordinar el cine en casa. |
| Flyweight | Comparte datos comunes de tipos de árboles. |
| Proxy | Carga una imagen solo cuando se muestra. |

Cada subcarpeta es una aplicación independiente. Desde la carpeta de un patrón:

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
