# Configuración externalizada

## Problema que aborda

La misma imagen debe funcionar en distintos entornos sin reconstruirla ni incluir secretos en el artefacto.

## En qué consiste

Inyecta configuración por variables, archivos o servicios de configuración al desplegar. Separa parámetros de entorno del código y gestiona secretos con herramientas dedicadas.

## Características y compromisos

Promueve artefactos inmutables y despliegues repetibles. Configuración inválida o exposición de secretos puede causar incidentes.

## Cuándo considerarlo

Aplicaciones desplegadas en múltiples entornos; valida configuración al inicio y aplica control de acceso y rotación.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

