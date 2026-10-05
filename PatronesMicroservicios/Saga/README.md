# Saga

## Problema que aborda

Una operación de negocio abarca varios servicios y no puede resolverse con una transacción ACID local única.

## En qué consiste

Divide el flujo en transacciones locales. Cada paso publica o activa el siguiente; ante fallas se ejecutan acciones compensatorias para revertir efectos de negocio.

## Características y compromisos

Permite coordinación distribuida sin bloqueo global. La consistencia es eventual y compensar no siempre equivale a deshacer exactamente el efecto original.

## Cuándo considerarlo

Procesos largos como reserva, pago y envío. Elige coreografía para flujos pequeños o coordinación explícita cuando la secuencia es compleja.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

