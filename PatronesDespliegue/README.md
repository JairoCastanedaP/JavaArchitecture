# Patrones de Despliegue (Deployment Patterns)

Los patrones de despliegue describen cómo introducir una nueva versión en los entornos y el tráfico productivo. Se diferencian por la exposición al riesgo, infraestructura adicional, rapidez de reversión y forma de validar cambios.

## Catálogo

- [Recreate (reemplazo)](Recreate/README.md): Se necesita una forma simple de reemplazar una versión y se acepta una interrupción durante la transición.
- [Rolling (actualización gradual)](Rolling/README.md): Se quiere actualizar instancias por grupos y mantener parte de la capacidad atendiendo tráfico.
- [Blue-Green (azul-verde)](BlueGreen/README.md): Se quiere preparar una versión nueva sin alterar el entorno que atiende tráfico y poder cambiar de vuelta con rapidez.
- [Canary (canario)](Canary/README.md): Se necesita validar una versión nueva con una fracción pequeña del tráfico real antes de ampliarla.
- [A/B Testing](ABTesting/README.md): Se necesita comparar el impacto de variantes para grupos de usuarios según una hipótesis de producto.
- [Shadow (tráfico espejo)](Shadow/README.md): Se quiere probar una versión nueva con solicitudes reales sin que sus respuestas afecten a los usuarios.
- [Ring (anillos de despliegue)](Ring/README.md): Una actualización debe alcanzar grupos de entornos o usuarios de forma escalonada según confianza.
- [Feature Flags (banderas de funcionalidad)](FeatureFlags/README.md): El despliegue del código y la activación de una capacidad deben ocurrir en momentos distintos.

Los patrones se pueden combinar y algunos aparecen en más de una categoría. La clasificación indica el contexto de estudio, no una frontera estricta.

## Referencia general

[Documentación de referencia](<https://kubernetes.io/docs/tutorials/stateless-application/canary-deployment/>)

