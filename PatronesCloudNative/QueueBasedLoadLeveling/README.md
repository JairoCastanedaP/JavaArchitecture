# Nivelación de carga mediante cola

## Problema que aborda

Los productores envían trabajo en ráfagas mayores que la capacidad instantánea de los consumidores.

## En qué consiste

Una cola desacopla la recepción del procesamiento. Consumidores trabajan a un ritmo controlado y escalan según la profundidad o antigüedad de la cola.

## Características y compromisos

Absorbe picos y desacopla ciclos de vida. Aumenta latencia y obliga a gestionar duplicados, mensajes fallidos y límites de espera.

## Cuándo considerarlo

Procesamiento asíncrono donde el cliente puede aceptar confirmación de recepción antes del resultado final.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

