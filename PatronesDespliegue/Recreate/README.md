# Recreate (reemplazo)

## Problema que aborda

Se necesita una forma simple de reemplazar una versión y se acepta una interrupción durante la transición.

## En qué consiste

Detiene las instancias de la versión actual y luego inicia las nuevas. En el intervalo, el servicio puede no estar disponible.

## Características y compromisos

Sencillo y no requiere ejecutar dos versiones simultáneamente. Causa downtime y una reversión puede tardar.

## Cuándo considerarlo

Entornos de desarrollo o servicios donde la interrupción está aceptada.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

