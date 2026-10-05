# Strangler Fig (estrangulamiento progresivo)

## Problema que aborda

Reemplazar un sistema legado de una sola vez implica alto riesgo y una migración difícil de revertir.

## En qué consiste

Un proxy o capa de enrutamiento dirige gradualmente funciones seleccionadas al sistema nuevo mientras el resto sigue en el legado. Se migra por capacidades.

## Características y compromisos

Permite entregas incrementales y comparación de comportamiento. Durante la transición hay dos sistemas, sincronización y rutas que administrar.

## Cuándo considerarlo

Modernizar sistemas grandes por partes con validación progresiva y posibilidad de volver atrás.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

