# Circuit Breaker (cortacircuitos)

## Problema que aborda

Las llamadas repetidas a una dependencia fallida consumen recursos y pueden propagar la falla.

## En qué consiste

El cliente observa resultados y alterna entre cerrado (llama), abierto (falla rápido) y semiabierto (prueba recuperación). Puede ofrecer respuesta alternativa.

## Características y compromisos

Limita cascadas y libera recursos para recuperarse. Umbrales, ventanas, tiempos de espera y respuestas de respaldo deben ajustarse al caso.

## Cuándo considerarlo

Llamadas a servicios o recursos remotos propensos a fallas. Acompáñalo con timeouts y reintentos limitados; no reintentes ciegamente.

## Referencia

[Consulta de referencia](<https://microservices.io/patterns/>)

