# CQRS (separación de comandos y consultas)

## Problema que aborda

Las necesidades de escritura y lectura tienen modelos, rendimiento o escalabilidad diferentes.

## En qué consiste

Separa operaciones que cambian estado (comandos) de consultas. Puede mantener modelos de lectura derivados y sincronizados con eventos.

## Características y compromisos

Optimiza cada camino y clarifica intención. Introduce sincronización, duplicación de modelos y consistencia eventual si las vistas se actualizan de forma asíncrona.

## Cuándo considerarlo

Dominios con consultas muy distintas de las transacciones de escritura. No es necesario para CRUD simple.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

