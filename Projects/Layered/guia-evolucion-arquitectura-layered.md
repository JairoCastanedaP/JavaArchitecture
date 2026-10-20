# Guía de aprendizaje: evolución de la aplicación CRUD por versiones

## Cómo leer esta guía

La carpeta `02.-Use cases` contiene seis proyectos independientes: `app-demo-v1`, `app-demo-v2`, `app-demo-v3`, `app-demo-v4.a`, `app-demo-v4.b` y `app-demo-v5.a`. Cada uno es una instantánea de la aplicación, no un módulo de un solo Maven multi-módulo. Los `pom.xml` conservan una base parecida de Spring Boot, Java, Spring Web MVC, Spring Data JPA, validación, H2 y MySQL; la evolución más importante ocurre en el código y en la organización de paquetes.

La secuencia pedagógica que se desprende del código es: **hacer funcionar el CRUD → separar responsabilidades → separar el contrato HTTP del modelo persistente → ampliar a otro dominio → organizar por dominio → reutilizar lo común**.

## Vista rápida

| Versión | Cambio que enseña | Flujo principal |
|---|---|---|
| v1 | CRUD mínimo y persistencia con Spring Data JPA | Controller → Repository → Entity |
| v2 | Capa de servicio e interfaz | Controller → Service → Repository → Entity |
| v3 | DTOs, validación, MapStruct, reglas y excepciones | Controller → DTO → Service → Mapper/Repository → Entity |
| v4.a | Segundo caso de uso: Supplier, conservando paquetes por capa | Controller → Service → Mapper/Repository → Entity, para Customer y Supplier |
| v4.b | Reorganización por dominio: `customer` y `supplier` | Mismo flujo, con cada dominio agrupando sus componentes |
| v5.a | Abstracciones genéricas, entidad/auditoría comunes y respuestas reutilizables | API de dominio → Service genérico → Repository genérico; mapeo y persistencia específicos |

## v1 — CRUD directo: descubrir el recorrido de una petición

**Propósito.** Construir primero una API pequeña para clientes y comprobar cómo Spring MVC y Spring Data JPA resuelven un CRUD básico.

**Clases clave.** `controller/CustomerController.java` declara `GET /api/v1/customers`, `POST /api/v1/customers` y `PUT /api/v1/customers/{id}`. Inyecta directamente `CustomerRepository`. `repository/CustomerRepository.java` extiende `JpaRepository<CustomerEntity, Long>`, que proporciona operaciones CRUD. `entity/CustomerEntity.java` representa tanto la fila JPA (`customers`) como, en la práctica, el objeto recibido o devuelto por HTTP.

**Flujo y decisión arquitectónica.** La petición entra al controlador, este llama al repositorio y retorna la entidad. En la actualización el controlador busca el registro, cambia sus campos y guarda. Todavía no hay una capa de servicio: el controlador mezcla transporte HTTP, coordinación y parte de la lógica.

**Conceptos aprendidos.** Anotaciones REST (`@RestController`, `@RequestMapping`, `@GetMapping`, etc.), `ResponseEntity`, inyección por constructor, entidades JPA, repositorios Spring Data y códigos HTTP básicos (por ejemplo, creación con `201 Created`). La configuración contempla H2 y MySQL mediante recursos de aplicación.

**Límite que motiva v2.** Si las reglas de negocio se agregan al controlador, este deja de ser una frontera HTTP sencilla y la misma lógica no se puede reutilizar con facilidad.

## v2 — Servicio: mover la lógica fuera del controlador

**Qué cambia.** Se agregan `service/CustomerService.java` y `service/CustomerServiceImpl.java`. El controlador deja de inyectar el repositorio y pasa a depender de la interfaz `CustomerService`. La implementación del servicio coordina el acceso al repositorio y concentra `getAll`, `getById`, `save` y `update`.

**Flujo.** HTTP → `CustomerController` → `CustomerService` → `CustomerRepository` → `CustomerEntity` → base de datos. La respuesta aún usa `CustomerEntity`, por lo que la frontera HTTP sigue expuesta al modelo de persistencia.

**Conceptos aprendidos.** Separación de responsabilidades, interfaz frente a implementación, servicio de aplicación y dependencias por constructor. El servicio es el lugar natural para reglas que requieren más que una llamada de persistencia.

**Límite que motiva v3.** El controlador y el cliente HTTP todavía intercambian la entidad JPA; también hace falta tratar validación y errores de forma coherente.

## v3 — Contratos HTTP, validación, mapeo y errores

**Qué cambia.** La API adopta `CustomerRequestDto` y `CustomerResponseDto` en `dto/`, usa `@Valid` en las entradas, y el contrato de servicio pasa a recibir y devolver DTOs. `mapper/CustomerMapper.java` declara conversiones entre DTO y entidad con MapStruct (`@Mapper(componentModel = "spring")`). El `pom.xml` incorpora MapStruct y configuración de procesadores de anotaciones junto con Lombok.

`CustomerServiceImpl` incorpora reglas de negocio: busca duplicados por nombre, comprueba existencia antes de modificar o borrar y realiza borrado lógico mediante `swDelete`. `CustomerException` expresa errores del dominio y `GlobalException` (`@RestControllerAdvice`) convierte errores de validación y de negocio en respuestas HTTP centralizadas. El repositorio expone búsqueda por nombre.

**Flujo de escritura.** JSON → `CustomerRequestDto` → validación automática → Controller → Service (reglas) → Mapper a `CustomerEntity` → Repository → base de datos. En lectura se realiza el camino inverso y se devuelve `CustomerResponseDto`.

**Conceptos aprendidos.** DTO como contrato independiente, validación declarativa, mapeo explícito, manejo global de excepciones, reglas de negocio en servicio, y diferencia entre borrado físico y lógico. Las rutas completan el CRUD con `DELETE`.

**Nota al estudiar el código.** Los nombres de clases y métodos son más fiables que asumir que cada detalle está terminado: por ejemplo, conviene revisar la definición de búsqueda por nombre del repositorio porque en v3 aparecen dos declaraciones con la misma firma. El ejemplo es útil para entender la intención de arquitectura, aunque esa duplicación requiere resolverla antes de tratar la versión como una implementación limpia.

## v4.a — Extender el patrón a Supplier

**Qué cambia.** Se añade el dominio `Supplier` además de `Customer`, con entidades, DTOs, controladores, servicios, repositorios, mappers y excepciones para ambos. Los componentes se organizan principalmente por capa: `controller/`, `service/`, `repository/`, `entity/`, `dto/`, `mapper/`. Cada dominio tiene sus propias reglas (por ejemplo, nombre de cliente frente a nombre de empresa) y sus rutas.

**Flujo.** Sigue el diseño de v3: Controller → Service → Mapper/Repository → Entity. La duplicación entre los dos CRUD se vuelve visible: los servicios repiten operaciones de listar, buscar, guardar, actualizar y borrar; los DTOs y mappers siguen siendo específicos.

**Conceptos aprendidos.** Generalizar un patrón probado a un segundo caso de uso permite descubrir qué partes son genuinamente comunes y cuáles pertenecen a cada negocio. Añadir una entidad no significa que se deban combinar reglas o contratos.

**Límite que motiva v4.b.** En una estructura por capas, encontrar todo lo relativo a un dominio requiere saltar entre varios paquetes.

## v4.b — Organización por dominio o feature

**Qué cambia.** La estructura agrupa las clases de cada caso de uso bajo `customer/` y `supplier/`; dentro de cada paquete aparecen sus controladores, servicios, entidades, DTOs, repositorios, mappers y excepciones. Las preocupaciones compartidas (por ejemplo, `exceptions/GlobalException`) permanecen en un ámbito común.

**Flujo y comportamiento.** La lógica de negocio es esencialmente la de v4.a. Este paso se entiende sobre todo como una reorganización del código, no como una nueva capa ni como un cambio del recorrido HTTP a base de datos.

**Conceptos aprendidos.** Organización por dominio (también llamada por feature o paquete vertical), cohesión y facilidad para localizar/modificar una funcionalidad completa. Se compara con la organización horizontal por capa de v4.a.

**Cómo elegir entre v4.a y v4.b.** La organización por capas ayuda a comparar implementaciones del mismo tipo técnico; la organización por dominio reúne lo que cambia junto cuando se modifica un caso de uso. La versión no es una arquitectura distinta en runtime: es una decisión de estructura del código.

## v5.a — Reutilización genérica y datos comunes

**Qué cambia.** Conserva Customer y Supplier, ahora organizados bajo `business/`, y agrega el espacio `generic/` para contratos reutilizables:

- `generic/service/GenericService<T,R,ID>` declara operaciones CRUD comunes.
- `generic/repository/GenericRepository<T,ID>` extiende `JpaRepository` y usa `@NoRepositoryBean` para evitar que Spring cree un repositorio concreto para la interfaz base.
- `generic/mapper/GenericMapper<E,REQ,RES>` establece conversiones comunes; `CustomerMapper` y `SupplierMapper` especializan los tipos.
- `generic/entity/GenericEntity` concentra estado, borrado lógico y campos de auditoría; las entidades de negocio heredan de ella.
- `generic/dto/GenericResponseDto` y `AuditResponseDto` ofrecen datos comunes de respuesta.
- `generic/exceptions/GenericException` sirve como supertipo para excepciones específicas.

Los repositorios de negocio agregan sus consultas específicas (por ejemplo `findByName` y `findByCompanyName`); los servicios mantienen validaciones y reglas propias del dominio. El `pom.xml` mantiene MapStruct y añade las dependencias asociadas a la persistencia/auditoría.

**Flujo.** La API de cada dominio recibe su DTO y delega en el servicio específico. El servicio aplica sus reglas, usa el mapper del dominio y un repositorio que hereda el CRUD genérico. La entidad hereda campos transversales y se persiste; el mapper proyecta respuesta y auditoría.

**Conceptos aprendidos.** Reutilización mediante genéricos, plantilla de operaciones comunes, superclase JPA con `@MappedSuperclass`, auditoría, y separación de lo común (generic) de las variaciones de negocio (business).

**Lo que el código sugiere que falta revisar.** `GenericController` está vacío y solo el controlador de clientes lo extiende; no parece existir una abstracción de controlador CRUD completa. `SupplierServiceImpl.findByDocumentNumber` devuelve `null`, aunque existe en la interfaz, y los métodos de consulta genéricos no filtran automáticamente registros con `swDelete = "0"`. La clase de auditoría tiene `@EntityListeners`, pero para que los campos automáticos se rellenen también debe estar habilitada la configuración de JPA auditing y debe existir una fuente de usuario si se espera completar `@CreatedBy`/`@LastModifiedBy`; hay que verificar esa configuración en el proyecto antes de asumir ese comportamiento. Así, v5.a demuestra la dirección de reutilización, pero no todas las abstracciones parecen acabadas.

## Un recorrido concreto: crear un cliente

1. En v1, el controlador recibe `CustomerEntity` y la guarda directamente.
2. En v2, recibe la entidad pero delega el caso de uso en `CustomerService`.
3. En v3, recibe un DTO validado; el servicio comprueba duplicados; MapStruct lo convierte en entidad; el repositorio persiste; el servicio convierte el resultado a DTO de salida.
4. En v4.a, la misma secuencia existe para Customer y Supplier, con paquetes por capa.
5. En v4.b, la misma secuencia se encuentra bajo los paquetes de cada dominio.
6. En v5.a, las operaciones comunes se expresan en interfaces genéricas y los campos transversales se heredan, mientras las consultas y reglas siguen siendo propias de cada dominio.

## Mapa mental final

```text
Cliente HTTP
    ↓ JSON / ruta
Controller (adaptador web: protocolo y estado HTTP)
    ↓ DTO
Service (caso de uso: reglas y coordinación)
    ├── Mapper (DTO ↔ Entity)
    └── Repository (persistencia)
             ↓
          Entity → Base de datos
```

El aprendizaje acumulativo es separar responsabilidades sin perder de vista el recorrido de una solicitud. DTOs aíslan la API de JPA; los servicios aíslan los casos de uso de HTTP; la organización por dominio mejora la cohesión del código; los componentes genéricos reducen repetición cuando de verdad existe comportamiento común. Las reglas particulares —unicidad, búsquedas específicas, validaciones propias— deben seguir visibles en su dominio.

## Qué mirar en los `pom.xml` y recursos

En todas las versiones, `pom.xml` muestra la base de ejecución: Spring Web MVC para la API, Spring Data JPA y el controlador H2/MySQL para persistencia, y Java 25 declarado. A partir de v3 aparece MapStruct y su procesamiento de anotaciones. En las versiones posteriores hay recursos `application-h2.yaml`, `application-mysql.yml` y `data.sql`, que permiten ver configuración y datos iniciales. Estos archivos explican el entorno de ejecución; no cambian por sí solos las capas de la arquitectura.

## Orden recomendado para repasar

1. Lee `CustomerController` de v1 y sigue la llamada hasta `CustomerRepository`.
2. Compara los mismos archivos en v2 e identifica qué código se movió al servicio.
3. En v3, sigue un `POST` desde `CustomerRequestDto` hasta `CustomerEntity` y de vuelta a `CustomerResponseDto`; después mira validación y `GlobalException`.
4. Compara el árbol de paquetes de v4.a con v4.b, sin confundir cambio de ubicación con cambio de comportamiento.
5. En v5.a, empieza por `GenericService`, `GenericRepository`, `GenericMapper` y `GenericEntity`; luego rastrea qué queda específico en Customer y Supplier.
6. Para cerrar, anota diferencias entre intención y código implementado, en particular consultas duplicadas/no implementadas y auditoría.
