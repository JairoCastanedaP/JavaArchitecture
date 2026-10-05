# Shadow (tráfico espejo)

## Problema que aborda

Se quiere probar una versión nueva con solicitudes reales sin que sus respuestas afecten a los usuarios.

## En qué consiste

Duplica solicitudes hacia la versión candidata mientras la versión estable continúa respondiendo. Se comparan resultados y comportamiento.

## Características y compromisos

Evalúa con carga y datos reales sin cambiar la respuesta visible. Puede duplicar costos y producir efectos secundarios si la réplica escribe datos.

## Cuándo considerarlo

Validar rendimiento o compatibilidad; la versión sombra debe proteger sistemas externos y datos de efectos no deseados.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

