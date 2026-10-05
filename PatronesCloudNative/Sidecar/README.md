# Sidecar

## Problema que aborda

Una capacidad transversal (por ejemplo, proxy, telemetría o certificados) debe acompañar a una aplicación sin incorporarse a su código.

## En qué consiste

Ejecuta un proceso auxiliar junto al contenedor o instancia principal, compartiendo parte de su ciclo de vida y recursos.

## Características y compromisos

Aísla preocupaciones y permite reutilizar funciones. Consume recursos adicionales y requiere gestionar versiones y comunicación entre contenedores.

## Cuándo considerarlo

Cuando varios servicios necesitan la misma capacidad auxiliar y la plataforma no la ofrece mejor como servicio administrado.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

