# Base de datos por servicio

## Problema que aborda

Una base compartida permite a cualquier servicio leer y modificar datos internos de los demás, acoplando despliegues y modelos.

## En qué consiste

Cada servicio posee sus datos y los demás acceden a ellos mediante su API o eventos, no consultando directamente su almacenamiento.

## Características y compromisos

Permite modelos y ciclos de cambio independientes. Consultas entre dominios y transacciones que abarcan servicios requieren composición, eventos o sagas.

## Cuándo considerarlo

Servicios que necesitan autonomía de despliegue y propiedad explícita de datos; no significa necesariamente un servidor físico distinto por servicio.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

