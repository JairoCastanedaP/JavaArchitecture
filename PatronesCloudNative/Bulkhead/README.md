# Bulkhead (mamparo)

## Problema que aborda

Una dependencia lenta o una carga excesiva puede consumir todos los recursos compartidos y afectar a componentes no relacionados.

## En qué consiste

Aísla recursos en grupos o límites separados, por ejemplo, pools de conexiones o cuotas por dependencia, de modo que una falla quede contenida.

## Características y compromisos

Reduce el radio de impacto. Una partición insuficiente o una asignación rígida puede desperdiciar capacidad.

## Cuándo considerarlo

Servicios que llaman varias dependencias o ejecutan trabajos con perfiles de carga diferentes.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

