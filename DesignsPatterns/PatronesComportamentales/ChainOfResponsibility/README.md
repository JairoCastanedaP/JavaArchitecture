# Chain of Responsibility (Cadena de responsabilidad)

## Propósito

Permite que varios manejadores tengan la oportunidad de procesar una solicitud. Cada manejador la resuelve o la pasa al siguiente, desacoplando al emisor del receptor final.

## Estructura del ejemplo

`SupportHandler` mantiene el siguiente elemento y define el flujo. `HelpDesk`, `Technician` y `Manager` procesan distintos tipos de problema. La solicitud avanza hasta encontrar quien la atienda.

## Características y uso

- El emisor no necesita conocer qué manejador resolverá el caso.
- El orden de la cadena determina qué manejador tiene prioridad.
- Úsala en filtros, validaciones, autorización o niveles de soporte.
- Una solicitud puede no ser atendida; define un último manejador o un resultado explícito.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
