# Canary (canario)

## Problema que aborda

Se necesita validar una versión nueva con una fracción pequeña del tráfico real antes de ampliarla.

## En qué consiste

Despliega la nueva versión junto a la estable, dirige una porción controlada de solicitudes y compara métricas; amplía o revierte según criterios.

## Características y compromisos

Limita la exposición inicial y aporta señales de producción. Requiere división de tráfico, monitoreo y criterios objetivos.

## Cuándo considerarlo

Cambios de riesgo o sistemas de alto tráfico con capacidad de enrutar y observar subconjuntos.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

