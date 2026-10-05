# Transactional Outbox (buzón transaccional)

## Problema que aborda

Actualizar una base de datos y publicar un evento por separado puede dejar solo una de las dos operaciones completada.

## En qué consiste

Guarda el cambio de negocio y un mensaje en una tabla outbox dentro de la misma transacción local. Un proceso publica luego el mensaje al broker y marca su avance.

## Características y compromisos

Evita la inconsistencia de doble escritura. La publicación puede repetirse, así que consumidores deben tolerar duplicados y el outbox necesita limpieza.

## Cuándo considerarlo

Publicar eventos después de cambios persistidos sin depender de una transacción distribuida entre base y broker.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

