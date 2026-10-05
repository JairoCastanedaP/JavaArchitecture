# Contenedor de inicialización

## Problema que aborda

La aplicación requiere preparación previa, como esperar una dependencia, descargar configuración o ajustar permisos.

## En qué consiste

El orquestador ejecuta uno o más contenedores de inicialización antes del contenedor principal; deben completarse para que la carga arranque.

## Características y compromisos

Separa tareas de preparación de la aplicación principal. No debe usarse para esperar indefinidamente ni para ocultar dependencias frágiles.

## Cuándo considerarlo

Preparaciones acotadas previas al arranque en plataformas de contenedores como Kubernetes.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

