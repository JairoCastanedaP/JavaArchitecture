# Ring (anillos de despliegue)

## Problema que aborda

Una actualización debe alcanzar grupos de entornos o usuarios de forma escalonada según confianza.

## En qué consiste

Despliega primero a un anillo interno, después a grupos piloto y finalmente a toda la población. Cada etapa requiere criterios de avance y rollback.

## Características y compromisos

Amplía gradualmente la exposición y ofrece puntos de evaluación. Requiere segmentación, automatización y disciplina para detener la progresión.

## Cuándo considerarlo

Plataformas grandes, actualizaciones de clientes o flotas distribuidas con grupos de validación.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

