# Arquitectura hexagonal (puertos y adaptadores)

## Problema que aborda

La lógica central queda ligada a bases de datos, interfaces, frameworks u otros detalles externos.

## En qué consiste

El dominio define puertos (contratos) para lo que necesita o expone; adaptadores implementan esos puertos para tecnologías concretas. Las dependencias apuntan hacia el núcleo.

## Características y compromisos

Facilita pruebas y sustitución de infraestructura, y protege reglas del dominio. Requiere definir puertos útiles y puede introducir abstracciones innecesarias en proyectos pequeños.

## Cuándo considerarlo

Dominios con reglas importantes, varias interfaces o necesidad de probar sin infraestructura real.

## Referencia

[Consulta de referencia](<https://learn.microsoft.com/en-us/azure/architecture/guide/architecture-styles/>)

