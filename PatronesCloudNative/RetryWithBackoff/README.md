# Reintento con espera progresiva

## Problema que aborda

Fallas temporales de red o saturación pueden hacer fallar una operación que tendría éxito al repetirla.

## En qué consiste

Repite solo errores transitorios, con cantidad limitada, espera creciente y variación aleatoria (jitter). Respeta deadlines e idempotencia.

## Características y compromisos

Aumenta tolerancia a fallas breves. Reintentos ilimitados o sincronizados amplifican una sobrecarga; algunas operaciones no son seguras de repetir.

## Cuándo considerarlo

Llamadas distribuidas con política coordinada de timeout, circuito y deduplicación.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

