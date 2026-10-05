# Blue-Green (azul-verde)

## Problema que aborda

Se quiere preparar una versión nueva sin alterar el entorno que atiende tráfico y poder cambiar de vuelta con rapidez.

## En qué consiste

Mantiene dos entornos similares: uno activo y otro actualizado. Tras validar el segundo, cambia el enrutamiento; el anterior queda disponible para rollback.

## Características y compromisos

Cambio y reversión de tráfico rápidos. Requiere capacidad duplicada y migraciones de datos compatibles con ambas versiones.

## Cuándo considerarlo

Aplicaciones donde el costo de duplicar temporalmente infraestructura se justifica por una reversión rápida.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

