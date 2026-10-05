# Arquitectura en capas

## Problema que aborda

Cuando presentación, reglas de negocio y acceso a datos se mezclan, los cambios se propagan por toda la aplicación.

## En qué consiste

Divide el sistema en capas con responsabilidades claras. Una organización habitual separa presentación, aplicación o dominio, y persistencia; cada capa ofrece servicios a la superior.

## Características y compromisos

Facilita comprender, probar y sustituir partes; puede reforzar separación de responsabilidades. Las llamadas atravesando muchas capas agregan latencia y las reglas estrictas de dependencia pueden ser difíciles de mantener.

## Cuándo considerarlo

Aplicaciones empresariales con límites funcionales relativamente claros. Evita capas vacías y dependencias que salten arbitrariamente entre niveles.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/guide/architecture-styles/>)

