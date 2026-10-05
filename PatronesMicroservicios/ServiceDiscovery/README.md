# Descubrimiento de servicios

## Problema que aborda

Las ubicaciones de instancias cambian con escalado, fallas y despliegues, por lo que no pueden mantenerse en una lista fija.

## En qué consiste

Un registro o plataforma de infraestructura asocia nombres lógicos con instancias saludables. Los clientes o un balanceador consultan ese registro.

## Características y compromisos

Permite localizar instancias dinámicas. Añade dependencia del registro, verificaciones de salud y mecanismos de caché o respaldo.

## Cuándo considerarlo

Entornos dinámicos con instancias que aparecen y desaparecen; en plataformas con descubrimiento incorporado, evita duplicar sus funciones en la aplicación.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

