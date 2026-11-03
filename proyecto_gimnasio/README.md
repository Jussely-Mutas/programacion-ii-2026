# 🏋️‍♂️ Sistema de Gestión de Membresías de Gimnasio 

## 👤 Datos del Estudiante
* **Nombre completo:** Jussely Saraí Mutas Chitic
* **Número de carné:** 9941-25-28221
* **Proyecto:** PF-06

---

## 📋 Descripción del Problema
El gimnasio requiere automatizar el control administrativo de sus clientes, planes de entrenamiento y la asignación de membresías vigentes. El sistema actual busca resolver la falta de control centralizado mediante una arquitectura robusta que garantice la persistencia relacional de los datos, la validación estricta de campos y un flujo de comunicación fluido entre un backend moderno basado en API REST y una interfaz web interactiva.

---

## 🛠️ Tecnologías Utilizadas
* **Backend:** Java 17+, Spring Boot (Spring Data JPA, Spring Web, Validation).
* **Base de Datos:** PostgreSQL, pgAdmin 4.
* **Frontend:** HTML5, CSS3, JavaScript (Vanilla con peticiones asíncronas `fetch`).
* **Herramientas de Desarrollo:** IntelliJ IDEA Ultimate, Postman, Git y GitHub.

---

## 📂 Estructura General del Sistema
```text
proyecto_gimnasio/
│
├── src/main/java/com/estudiante/proyecto_gimnasio/
│   ├── controller/      # Controladores REST (ClienteController, MembresiaController, PlanController)
│   ├── dto/             # Objetos de transferencia de datos (DTOs)
│   ├── entity/          # Entidades JPA (Cliente, Plan, Membresía)
│   ├── repository/      # Repositorios Spring Data JPA
│   └── service/         # Lógica de negocio y reglas operativas
│
├── src/main/resources/
│   └── application.properties # Configuración de conexión a PostgreSQL
│
└── frontend/
    └── index.html       # Panel de control web e interfaz de usuario
```
___________________________________________________________________________________________________
## ⚙️ Requisitos para Ejecutar el Proyecto
* Tener instalado Java JDK 17 o superior.

* Tener instalado PostgreSQL y pgAdmin 4.

* Un entorno de desarrollo compatible con Java (como IntelliJ IDEA).

* Un navegador web moderno (Google Chrome, Edge, Firefox, etc.) para visualizar la interfaz.
```
_______________________________________________________________________________________
## 🗄️ Configuración de PostgreSQL
Crea una base de datos en PostgreSQL llamada proyecto_gimnasio.

Verifica los parámetros de conexión en tu archivo src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/proyecto_gimnasio
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
___________________________________________________________________________________________
## 🚀 Instrucciones para Iniciar el Backend
Clona o abre el proyecto backend en IntelliJ IDEA.

Espera a que Maven descargue e indexe todas las dependencias del archivo pom.xml.

Ejecuta la clase principal del proyecto (ProyectoGimnasioApplication.java) o presiona el botón verde de Play (Run).

Confirma en la consola que el servidor Tomcat ha iniciado correctamente en el puerto 8080.
```


## 🌐 Instrucciones para Abrir el Frontend
Localiza el archivo con la interfaz gráfica (index.html) en tu equipo.

Haz doble clic sobre él para abrirlo directamente en tu navegador web favorito.

Utiliza el botón "🔄 Refrescar Listas" para verificar la comunicación inmediata con la API y cargar los registros desde la base de datos.

```

## 🔌 Descripción de los Endpoints
Clientes (/api/clientes):

GET /api/clientes - Lista todos los clientes registrados.

POST /api/clientes - Registra un nuevo cliente con validaciones Jakarta (@Valid).

PUT /api/clientes/{id} - Actualiza los datos de un cliente existente.

DELETE /api/clientes/{id} - Elimina un cliente del sistema.

Planes (/api/planes):

GET /api/planes - Obtiene el catálogo de planes disponibles.

POST /api/planes - Crea un nuevo plan de membresía.

PUT /api/planes/{id} - Actualiza un plan existente.

DELETE /api/planes/{id} - Elimina un plan del sistema.

Membresías (/api/membresias):

POST /api/membresias - Asigna una membresía vinculando a un cliente y un plan.

GET /api/membresias - Lista todas las membresías creadas.

GET /api/membresias/activas - Filtro dedicado para consultar únicamente las membresías vigentes/activas.

```

## ⚖️ Reglas Principales del Negocio
Cálculo dinámico de estados: El estado de las membresías (Activa o Vencida) se calcula en tiempo real con base en la fecha de inicio del plan y su duración asociada.

Políticas CORS habilitadas: Se configuró @CrossOrigin(origins = "*") en los controladores para permitir la comunicación segura y sin restricciones entre la interfaz web y el servidor local.

Validación de datos: Uso estricto de DTOs y anotaciones Jakarta para asegurar la integridad de la información antes de persistirla en PostgreSQL.

