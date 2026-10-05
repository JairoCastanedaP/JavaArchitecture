# Patrones de Microservicios

Estos patrones abordan límites de servicio, datos propios, comunicación, resiliencia y evolución de sistemas distribuidos. No son una receta para convertir toda aplicación en microservicios: distribuyen complejidad y requieren operación, automatización y observabilidad.

## Catálogo

- [Descomposición por capacidad de negocio](DecomposeByBusinessCapability/README.md): Un monolito debe dividirse, pero separar por tablas o capas técnicas crea servicios que siguen acoplados.
- [Base de datos por servicio](DatabasePerService/README.md): Una base compartida permite a cualquier servicio leer y modificar datos internos de los demás, acoplando despliegues y modelos.
- [API Gateway (puerta de enlace)](ApiGateway/README.md): Los clientes deben conocer múltiples endpoints, protocolos y reglas de seguridad internas.
- [Backend for Frontend (BFF)](BackendForFrontend/README.md): Una API general obliga a clientes distintos (web, móvil, dispositivo) a recibir datos excesivos o hacer muchas llamadas.
- [Descubrimiento de servicios](ServiceDiscovery/README.md): Las ubicaciones de instancias cambian con escalado, fallas y despliegues, por lo que no pueden mantenerse en una lista fija.
- [Saga](Saga/README.md): Una operación de negocio abarca varios servicios y no puede resolverse con una transacción ACID local única.
- [CQRS (separación de comandos y consultas)](CQRS/README.md): Las necesidades de escritura y lectura tienen modelos, rendimiento o escalabilidad diferentes.
- [Event Sourcing (persistencia de eventos)](EventSourcing/README.md): Guardar solo el estado actual dificulta conocer cómo evolucionó y reconstruir decisiones históricas.
- [Circuit Breaker (cortacircuitos)](CircuitBreaker/README.md): Las llamadas repetidas a una dependencia fallida consumen recursos y pueden propagar la falla.
- [Transactional Outbox (buzón transaccional)](TransactionalOutbox/README.md): Actualizar una base de datos y publicar un evento por separado puede dejar solo una de las dos operaciones completada.
- [Strangler Fig (estrangulamiento progresivo)](StranglerFig/README.md): Reemplazar un sistema legado de una sola vez implica alto riesgo y una migración difícil de revertir.

Los patrones se pueden combinar y algunos aparecen en más de una categoría. La clasificación indica el contexto de estudio, no una frontera estricta.

## Referencia general

[Documentación de referencia](<https://microservices.io/patterns/>)

