# Sondas de salud

## Problema que aborda

El orquestador necesita saber si una instancia está iniciando, puede recibir tráfico o debe reiniciarse.

## En qué consiste

Expone comprobaciones distintas: inicio (startup), disponibilidad (readiness) y vida (liveness). La plataforma las usa para decidir cuándo enrutar o reiniciar.

## Características y compromisos

Automatiza recuperación y evita enviar tráfico a instancias no preparadas. Sondas mal configuradas pueden provocar reinicios en cascada o falsos positivos.

## Cuándo considerarlo

Servicios contenerizados. Mantén las comprobaciones ligeras y separa disponibilidad de dependencias según la política de operación.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

