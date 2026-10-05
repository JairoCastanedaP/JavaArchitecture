# Flyweight (Peso ligero)

## Propósito

Reduce el uso de memoria compartiendo datos comunes entre muchos objetos similares. Separa el estado intrínseco compartido del estado extrínseco que varía por cada instancia o contexto.

## Estructura del ejemplo

`TreeType` guarda especie y color, que se comparten. `Tree` conserva coordenadas propias y una referencia al tipo. `TreeTypeFactory` reutiliza un tipo existente en vez de duplicarlo.

## Características y uso

- Una fábrica o caché administra los objetos compartidos.
- El estado compartido debe ser inmutable o tratarse con cuidado.
- Úsalo cuando existan grandes cantidades de objetos con datos repetidos.
- Añade búsquedas y complejidad; mide el consumo antes de aplicarlo.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
