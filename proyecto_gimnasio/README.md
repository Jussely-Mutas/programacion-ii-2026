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
_______________________________________________________
**Nombre del Estudiante:** Jussely Saraí Mutas Chitic