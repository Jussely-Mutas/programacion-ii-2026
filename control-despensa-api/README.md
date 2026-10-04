# Control de Despensa API REST
## Datos del Estudiante
* **Nombre completo:** Jussely Saraí Mutas Chitic
* **Número de carné:** 9941-25-28221

## 1. Nombre de la Actividad
Desarrollo de API REST con Spring Boot - Control de Despensa

## 2. Descripción del Problema
Desarrollo e implementación de una API REST que permita gestionar y consultar la información de productos registrados en un sistema de control de despensa o inventario. La solución implementa el patrón arquitectónico MVC y expone endpoints HTTP para realizar búsquedas, filtros por categoría, productos con bajo stock, producto de mayor valor acumulado y resúmenes estadísticos generales.

## 3. Tecnologías Utilizadas
* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3.x (Spring Web)
* **Gestor de Dependencias:** Apache Maven
* **IDE:** IntelliJ IDEA
* **Formato de Intercambio de Datos:** JSON (serialización con Jackson)

## 4. Requisitos para Ejecutar el Proyecto
* JDK 17 o superior instalado y configurado en el sistema.
* Apache Maven (o el wrapper `mvnw` incluido en el proyecto).
* Navegador web o cliente HTTP (Postman, cURL, etc.).

## 5. Estructura Principal
```text
control-despensa-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/estudiante/despensa/
│   │   │       ├── ControlDespensaApiApplication.java
│   │   │       ├── controller/
│   │   │       │   └── ProductoController.java
│   │   │       └── model/
│   │   │           ├── Producto.java
│   │   │           └── ResumenInventario.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```
## 6. Explicación de las Clases
  * **Producto.java:** Representa el modelo de entidad principal de la aplicación. Contiene las propiedades fundamentales de cada artículo del inventario (id, nombre, categoria, cantidad y precio), junto con sus constructores, métodos getters y setters, y un método para calcular el subtotal acumulado por producto (cantidad × precio).

* **ResumenInventario.java:** Objeto de transferencia de datos (DTO) diseñado para consolidar y transportar los indicadores globales de la despensa. Contiene los atributos totalProductos (cantidad de registros), totalUnidades (suma física de existencias) y valorTotalInventario (monto acumulado en moneda local).

* **ProductoController.java:** Controlador REST principal decorado con @RestController y @RequestMapping("/api/productos"). Contiene la lista en memoria de productos y expone todos los métodos que atienden las peticiones HTTP GET, aplicando filtros con la API Stream de Java y gestionando la respuesta con ResponseEntity.

* **ControlDespensaApiApplication.java:** Clase de arranque del proyecto annotated con @SpringBootApplication. Contiene el método main, el cual inicia el contexto de Spring Boot y levanta el servidor web embebido Apache Tomcat en el puerto 8080.

## 7. Tabla de Endpoints

| Operación | Método | Ruta | Estado esperado |
| :--- | :--- | :--- | :--- |
| **Listar productos** | `GET` | `/api/productos` | `200` |
| **Buscar por identificador** | `GET` | `/api/productos/{id}` | `200` o `404` |
| **Buscar por categoría** | `GET` | `/api/productos/categoria/{categoria}` | `200` |
| **Consultar stock bajo** | `GET` | `/api/productos/stock-bajo` | `200` |
| **Consultar producto de mayor valor** | `GET` | `/api/productos/mayor-valor` | `200` |
| **Obtener resumen** | `GET` | `/api/productos/resumen` | `200` |

## 8. Instrucciones para Ejecutar la Aplicación

1. Clona o descarga el repositorio a tu equipo local.
2. Abre el proyecto en **IntelliJ IDEA**.
3. Asegúrate de cargar las dependencias de Maven a través del archivo `pom.xml`.
4. Ejecuta la clase principal `ControlDespensaApiApplication.java` (o presiona `Shift + F10`).
5. Abre un navegador web e ingresa a `http://localhost:8080/api/productos` para verificar que la aplicación responda.

## 9. Ejemplos de Respuestas JSON

* **Consulta General (`GET /api/productos`):**
```json
[
  {
    "id": 1,
    "nombre": "Leche Entera",
    "categoria": "Lácteos",
    "cantidad": 5,
    "precio": 12.50
  },
  {
    "id": 2,
    "nombre": "Queso Crema",
    "categoria": "Lácteos",
    "cantidad": 2,
    "precio": 28.00
  }
]
```
* **Consulta Resumen (`GET /api/productos/resumen`):**
```json
{
  "totalProductos": 6,
  "totalUnidades": 25,
  "valorTotalInventario": 357.50
}
```
* **Producto de Mayor valor (`GET /api/productos/mayor-valor`):**
```json
{
  "id": 5,
  "nombre": "Detergente Líquido para manos",
  "categoria": "Limpieza",
  "cantidad": 3,
  "precio": 45.00
}
```




