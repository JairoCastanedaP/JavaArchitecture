# Feature Flags (banderas de funcionalidad)

## Problema que aborda

El despliegue del código y la activación de una capacidad deben ocurrir en momentos distintos.

## En qué consiste

Incluye una condición de configuración que habilita una funcionalidad por entorno, usuario o segmento. El artefacto puede desplegarse antes de activar la función.

## Características y compromisos

Permite activación gradual y apagado rápido sin volver a desplegar. Banderas olvidadas aumentan complejidad y pueden crear combinaciones difíciles de probar.

## Cuándo considerarlo

Separar release de lanzamiento. Mantén responsables, caducidad y pruebas de configuraciones de banderas.

## Referencia

[Consulta de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

