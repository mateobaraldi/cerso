# Trabajo Práctico Integrador - API REST con Spring Boot

**Asignatura:** Proyecto, diseño e implementación de sistemas computacionales  
**Modalidad:** Individual / En parejas  
**Tecnologías:** Java 21, Spring Boot 3, Spring Data JPA, Jakarta Validation, MySQL  

---

## 1. Descripción del Proyecto
API RESTful desarrollada para la gestión de un catálogo de **Productos**. Aplica una arquitectura estructurada por capas (Controller, Service, Repository, DTO y Entity) garantizando la separación de responsabilidades, la persistencia en base de datos MySQL y un manejo centralizado de validaciones y excepciones.

---

## 2. Dominio y Atributos
La entidad principal **Producto** posee los siguientes 6 atributos:
* `id` (Long): Identificador único auto-generado.
* `nombre` (String): Nombre del producto (Obligatorio).
* `descripcion` (String): Detalle o especificación.
* `precio` (BigDecimal): Precio unitario (Obligatorio, > 0).
* `stock` (Integer): Cantidad disponible (Obligatorio, >= 0).
* `categoria` (String): Rubro o categoría (Obligatorio).

---

## 3. Requisitos de Configuración (`application.yaml`)
El proyecto está configurado mediante `src/main/resources/application.yaml` para conectarse a MySQL mediante XAMPP:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/productos_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    username: root
    password: ""
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
