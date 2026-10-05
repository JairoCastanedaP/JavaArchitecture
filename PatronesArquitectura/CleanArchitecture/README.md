# Arquitectura limpia

## Problema que aborda

Las reglas de negocio dependen de frameworks y detalles técnicos que cambian con frecuencia.

## En qué consiste

Organiza código en círculos de responsabilidad; las políticas internas no dependen de capas externas. Casos de uso coordinan entidades y los detalles se conectan mediante interfaces.

## Características y compromisos

Aísla políticas del dominio y mejora la capacidad de prueba. No prescribe una estructura única de carpetas; las interfaces adicionales tienen un costo de mantenimiento.

## Cuándo considerarlo

Aplicaciones con lógica de negocio duradera y múltiples dependencias técnicas. Se complementa, pero no es idéntica, a la arquitectura hexagonal.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/guide/architecture-styles/>)

