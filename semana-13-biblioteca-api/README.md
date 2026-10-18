# Sistema de Gestión - Biblioteca Personal (API REST)

## 1. Descripción del problema
Desarrollo de una API RESTful utilizando Spring Boot y PostgreSQL para la gestión integral de una biblioteca personal ("biblioteca_personal"). El sistema implementa operaciones CRUD completas, manejo de códigos de estado HTTP correctos, restricciones de unicidad y consultas adicionales por categoría y disponibilidad, sin utilizar listas en memoria ni capas adicionales no solicitadas (como Service o DTO).
_____________________________________________________________________
## 2. Tecnologías utilizadas
- Java (JDK 17 o superior)
- Spring Boot (Spring Web, Spring Data JPA)
- PostgreSQL (Base de datos relacional)
- pgAdmin 4 (Administración de base de datos)
- Postman (Pruebas de endpoints REST)
- Maven (Gestor de dependencias)
- IntelliJ IDEA (Entorno de desarrollo)
______________________________________________________________________
## 3. Estructura del proyecto
biblioteca_personal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tuproyecto/
│   │   │           ├── controller/   (Controladores REST - @RestController)
│   │   │           ├── model/        (Entidades JPA - @Entity Libro)
│   │   │           ├── repository/   (Interfaces de persistencia - JpaRepository)
│   │   │           └── BibliotecaPersonalApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties (Configuración de conexión)
│   └── test/
└── pom.xml
_________________________________________________________________________
## 4. Script SQL de la base de datos
CREATE DATABASE biblioteca_personal;

\c biblioteca_personal;

CREATE TABLE libro (
id BIGSERIAL PRIMARY KEY,
codigo VARCHAR(50) UNIQUE NOT NULL,
titulo VARCHAR(150) NOT NULL,
autor VARCHAR(100) NOT NULL,
categoria VARCHAR(50) NOT NULL,
anio_publicacion INT NOT NULL,
precio NUMERIC(10, 2) NOT NULL,
disponible BOOLEAN NOT NULL
);
__________________________________________________________________
## 5. Configuración general de la base de datos
El archivo application.properties contiene la siguiente configuración de conexión:

spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_personal
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
_____________________________________________________________________
## 6. Tabla de endpoints
| Método HTTP | Ruta | Descripción |
| :--- | :--- | :--- |
| POST | /api/libros | Registra un nuevo libro en el sistema. |
| GET | /api/libros | Retorna la lista completa de todos los libros. |
| GET | /api/libros/{id} | Busca un libro específico por su identificador único. |
| GET | /api/libros/categoria/{categoria} | Filtra y devuelve los libros por categoría. |
| GET | /api/libros/disponibles | Retorna únicamente los libros disponibles. |
| PUT | /api/libros/{id} | Actualiza la información de un libro existente. |
| DELETE | /api/libros/{id} | Elimina un libro del sistema según su ID. |
__________________________________________________________________
## 7. Instrucciones para ejecutar la aplicación
1. Crear la base de datos en PostgreSQL utilizando el script SQL provisto.
2. Abrir el proyecto en IntelliJ IDEA y verificar las credenciales en application.properties.
3. Ejecutar la clase principal BibliotecaPersonalApplication.java.
4. Importar y probar los endpoints desde Postman.
_______________________________________________________________

## 8.  Nombre del Estudiante
- Nombre: Jussely Saraí Mutas Chitic
- Carné: 9941-25-28221