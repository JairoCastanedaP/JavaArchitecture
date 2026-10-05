# Arquitectura dirigida por eventos

## Problema que aborda

Productores y consumidores necesitan evolucionar con menos dependencia temporal y directa.

## En qué consiste

Los productores publican eventos sobre hechos ocurridos y consumidores reaccionan a ellos, normalmente mediante un canal o intermediario. El productor no necesita conocer cada consumidor.

## Características y compromisos

Favorece extensión y procesamiento asíncrono, y puede absorber picos mediante colas. La observabilidad, el orden, los duplicados y la consistencia eventual necesitan atención.

## Cuándo considerarlo

Sistemas con flujos asíncronos, integración entre dominios o respuesta a cambios de estado.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/guide/architecture-styles/>)

