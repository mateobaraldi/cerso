# Trabajo Práctico Integrador - API REST con Spring Boot

**Asignatura:** Proyecto, diseño e implementación de sistemas computacionales  
**Tecnologías:** Java 21, Spring Boot 3, Spring Data JPA, Jakarta Validation, MySQL  

##  Descripción del Proyecto
API RESTful para la gestión de productos desarrollada aplicando una arquitectura por capas (Controller, Service, Repository, DTO y Entity) con persistencia en MySQL y validación centralizada de datos.

---

##  Requisitos Previos
* **Java:** JDK 21 o superior
* **Motor de Base de Datos:** MySQL (a través de XAMPP o servicio local)
* **Gestor de Dependencias:** Maven
* **Cliente de Pruebas:** Postman, Insomnia o cURL

---

##  Configuración y Ejecución

1. **Iniciar Base de Datos:**
   Asegurarse de tener activo el servicio de MySQL (por ejemplo, desde el panel de XAMPP presionando *Start* en MySQL).

2. **Configuración de Conexión:**
   La aplicación está configurada mediante `src/main/resources/application.yaml`. Se creará automáticamente la base de datos `productos_db` si no existe.

3. **Ejecutar la Aplicación:**
   Desde tu IDE (IntelliJ IDEA / Eclipse / VS Code), ejecutar la clase principal `com.example.demo.DemoApplication`.  
   Alternativamente, desde la consola en la raíz del proyecto:
   ```bash
   ./mvnw spring-boot:run
