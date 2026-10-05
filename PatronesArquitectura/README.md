# Patrones de Arquitectura

Los patrones de arquitectura describen la organización de alto nivel de un sistema: sus componentes principales, responsabilidades, dependencias y formas de comunicación. Son decisiones que afectan múltiples módulos y atributos de calidad.

## Catálogo

- [Arquitectura en capas](Layered/README.md): Cuando presentación, reglas de negocio y acceso a datos se mezclan, los cambios se propagan por toda la aplicación.
- [Cliente-servidor](ClientServer/README.md): Varios consumidores necesitan solicitar capacidades y datos de un proveedor compartido.
- [Modelo-vista-controlador](MVC/README.md): La interfaz, los datos y el tratamiento de acciones están acoplados, lo que dificulta cambiar o probarlos.
- [Microkernel (núcleo mínimo)](Microkernel/README.md): Un producto necesita un conjunto estable de funciones básicas y capacidades opcionales que varían entre instalaciones.
- [Tuberías y filtros](PipeAndFilter/README.md): Un procesamiento por etapas resulta difícil de reutilizar o modificar porque todas sus operaciones están unidas.
- [Arquitectura dirigida por eventos](EventDriven/README.md): Productores y consumidores necesitan evolucionar con menos dependencia temporal y directa.
- [Arquitectura hexagonal (puertos y adaptadores)](Hexagonal/README.md): La lógica central queda ligada a bases de datos, interfaces, frameworks u otros detalles externos.
- [Arquitectura limpia](CleanArchitecture/README.md): Las reglas de negocio dependen de frameworks y detalles técnicos que cambian con frecuencia.

Los patrones se pueden combinar y algunos aparecen en más de una categoría. La clasificación indica el contexto de estudio, no una frontera estricta.

## Referencia general

[Documentación de referencia](<https://learn.microsoft.com/en-us/azure/architecture/guide/architecture-styles/>)

