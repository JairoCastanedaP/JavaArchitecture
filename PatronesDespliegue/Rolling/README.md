# Rolling (actualización gradual)

## Problema que aborda

Se quiere actualizar instancias por grupos y mantener parte de la capacidad atendiendo tráfico.

## En qué consiste

Reemplaza progresivamente instancias antiguas por nuevas, controlando tamaño de lote, capacidad mínima y verificaciones de salud.

## Características y compromisos

Evita detener todo el servicio y limita el cambio por etapa. Durante la transición conviven versiones, que deben ser compatibles con API y datos.

## Cuándo considerarlo

Servicios replicados con despliegues graduales y compatibilidad temporal entre versiones.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

