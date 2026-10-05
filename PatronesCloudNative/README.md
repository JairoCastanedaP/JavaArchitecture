# Patrones Cloud Native

Los patrones cloud native aprovechan contenedores, orquestadores y servicios gestionados para construir cargas automatizables, observables y resilientes. Algunos también aparecen como patrones de arquitectura o microservicios; aquí se agrupan por su contexto de operación cloud native.

## Catálogo

- [Sidecar](Sidecar/README.md): Una capacidad transversal (por ejemplo, proxy, telemetría o certificados) debe acompañar a una aplicación sin incorporarse a su código.
- [Ambassador](Ambassador/README.md): La aplicación necesita comunicarse con servicios externos o remotos y se quiere ocultar complejidad de red.
- [Adaptador cloud native](Adapter/README.md): Una aplicación o componente expone métricas, protocolos o formatos que la plataforma de operación no entiende directamente.
- [Contenedor de inicialización](InitContainer/README.md): La aplicación requiere preparación previa, como esperar una dependencia, descargar configuración o ajustar permisos.
- [Configuración externalizada](ExternalizedConfiguration/README.md): La misma imagen debe funcionar en distintos entornos sin reconstruirla ni incluir secretos en el artefacto.
- [Sondas de salud](HealthProbe/README.md): El orquestador necesita saber si una instancia está iniciando, puede recibir tráfico o debe reiniciarse.
- [Infraestructura inmutable](ImmutableInfrastructure/README.md): Modificar servidores en producción de forma manual genera diferencias difíciles de reproducir.
- [Escalado automático](Autoscaling/README.md): La demanda cambia, y una capacidad fija puede desperdiciar recursos o quedar corta.
- [Bulkhead (mamparo)](Bulkhead/README.md): Una dependencia lenta o una carga excesiva puede consumir todos los recursos compartidos y afectar a componentes no relacionados.
- [Reintento con espera progresiva](RetryWithBackoff/README.md): Fallas temporales de red o saturación pueden hacer fallar una operación que tendría éxito al repetirla.
- [Nivelación de carga mediante cola](QueueBasedLoadLeveling/README.md): Los productores envían trabajo en ráfagas mayores que la capacidad instantánea de los consumidores.

Los patrones se pueden combinar y algunos aparecen en más de una categoría. La clasificación indica el contexto de estudio, no una frontera estricta.

## Referencia general

[Documentación de referencia](<https://learn.microsoft.com/en-us/azure/architecture/patterns/>)

