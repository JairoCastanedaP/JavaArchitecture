# API Gateway (puerta de enlace)

## Problema que aborda

Los clientes deben conocer múltiples endpoints, protocolos y reglas de seguridad internas.

## En qué consiste

Un punto de entrada enruta solicitudes hacia servicios y puede autenticar, limitar tráfico o componer respuestas. Mantiene políticas de borde fuera de cada cliente.

## Características y compromisos

Simplifica clientes y centraliza ciertas preocupaciones transversales. Puede convertirse en cuello de botella o concentrar demasiada lógica.

## Cuándo considerarlo

Exponer microservicios a clientes externos. Mantén el gateway enfocado en tráfico de entrada; considera BFF si las interfaces necesitan respuestas diferentes.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

