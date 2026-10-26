# 🏋️‍♂️ Sistema de Gestión de Gimnasio - API REST (Avance 1)

Este proyecto consiste en el desarrollo de un servicio web RESTful para la gestión de membresías y clientes de un gimnasio. Desarrollado con **Java 17** y **Spring Boot 3**, utilizando **PostgreSQL** como sistema de gestión de base de datos relacional.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.1.5
* **Persistencia:** Spring Data JPA
* **Base de Datos:** PostgreSQL
* **Validación:** Jakarta Bean Validation
* **Gestor de Dependencias:** Maven
* **Pruebas de API:** Postman

---

## 🗄️ Estructura de la Base de Datos

La base de datos `membresias_de_gimnasio` cuenta con la tabla `cliente`, configurada con las siguientes restricciones y tipos de datos:

| Columna | Tipo de Dato | Restricciones / Descripción |
| :--- | :--- | :--- |
| `id` | `BIGSERIAL` | Primary Key, Auto-incrementable |
| `nombre` | `VARCHAR(255)` | Obligatorio (`@NotBlank`) |
| `apellido` | `VARCHAR(255)` | Obligatorio (`@NotBlank`) |
| `correo` | `VARCHAR(255)` | Único, formato válido de e-mail (`@Email`) |
| `telefono` | `VARCHAR(255)` | Número de contacto del cliente |

---

## 📌 Endpoints de la API (Avance 1)

Base URL: `http://localhost:8080/api/clientes`

| Método HTTP | Ruta (Endpoint) | Descripción |
| :--- | :--- | :--- |
| **GET** | `/api/clientes` | Obtiene la lista completa de todos los clientes registrados. |
| **POST** | `/api/clientes` | Registra un nuevo cliente con validación de datos. |
| **GET** | `/api/clientes/buscar?nombre={nombre}` | Filtra clientes por coincidencia en el nombre (ignore case). |
| **GET** | `/api/clientes/resumen` | Retorna métricas generales del sistema. |

---

## 📝 Ejemplo de Petición JSON (POST)

**URL:** `http://localhost:8080/api/clientes`  
**Header:** `Content-Type: application/json`

```json
{
  "nombre": "Carlos",
  "apellido": "Gómez",
  "correo": "carlos.gomez@example.com",
  "telefono": "55551234"
}
```
## DTO, validaciones y manejo de errores

En esta sección se detalla la implementación de transferencia de datos, validaciones y gestión centralizada de excepciones para el módulo de membresías del sistema de gimnasio.

* **Entidad utilizada:** 
  Se utilizó la entidad `Membresia`, la cual mapea la tabla correspondiente en la base de datos PostgreSQL y se relaja mediante JPA con las entidades `Cliente` y `Plan`, gestionando fechas de inicio, vencimiento y el estado actual de la membresía.

* **DTO creado:** 
  Se implementó `MembresiaRequestDTO` para encapsular y transferir de forma segura los datos requeridos al registrar o actualizar una membresía ( IDs de cliente y plan, y fecha de inicio opcional).

* **Validaciones implementadas:** 
  Se aplicaron validaciones mediante anotaciones de Jakarta Bean Validation (como `@NotNull`, `@Positive`, etc.) en los DTOs y controladores (`@Valid`) para asegurar que los datos de entrada cumplan con los requisitos de negocio antes de ser procesados.

* **Excepción personalizada:** 
  Se creó la clase `RecursoNoEncontradoException` para manejar de forma específica los escenarios donde un recurso consultado (por ejemplo, una membresía por ID) no existe en la base de datos.

* **Códigos HTTP utilizados:** 
  * `200 OK`: Para consultas y listados exitosos.
  * `201 Created`: Para el registro exitoso de una nueva membresía.
  * `400 Bad Request`: Para errores de validación en los datos enviados.
  * `404 Not Found`: Cuando no se encuentra un recurso solicitado (ej. ID inexistente).

* **Forma de ejecutar y probar la API:** 
  1. Abrir el proyecto en IntelliJ IDEA.
  2. Ejecutar la clase principal `ProyectoGimnasioApplication`.
  3. Realizar las peticiones HTTP (GET, POST, etc.) utilizando Postman apuntando a `http://localhost:8080/api/membresias`.
_______________________________________________________
**Nombre del Estudiante:** Jussely Saraí Mutas Chitic
