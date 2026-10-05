# Event Sourcing (persistencia de eventos)

## Problema que aborda

Guardar solo el estado actual dificulta conocer cómo evolucionó y reconstruir decisiones históricas.

## En qué consiste

Almacena una secuencia de eventos de dominio como fuente de verdad y reconstruye el estado aplicando esos eventos en orden.

## Características y compromisos

Proporciona historial auditable y permite derivar proyecciones. Cambios de esquema, reconstrucciones, privacidad y retención son complejos.

## Cuándo considerarlo

Dominios que requieren trazabilidad histórica o reconstrucción. A menudo se combina con CQRS, pero son patrones distintos.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

