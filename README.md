# 🏨 Hotel Management API

Backend desarrollado en _Java Spring Boot_ para la gestión de un hotel.  
Permite administrar **habitaciones, reservas, clientes, empleados, pagos y servicios extras**.

---

## 👥 Integrantes

- Alarcón Noe Sebastián
- Anyoza Joel André

---

## 🧰 Tecnologías utilizadas

- Java 24
- Spring Boot 3.5.5
- Maven
- PostgreSQL
- JPA
- Postman
- Swagger

---

## 🎯 Alcance

El sistema tiene como finalidad **gestionar las operaciones principales de un hotel**, centradas en el lado **backend** (servicios y base de datos).

### ✅ Funcionalidades incluidas

- Gestión de habitaciones (registro, tipos, disponibilidad, precios).
- Gestión de clientes (datos personales y contacto).
- Gestión de reservas (crear, consultar, modificar, estados).
- Pagos (registro, métodos de pago, historial).
- Servicios extras (spa, lavandería, transporte) y su asociación a reservas.
- Gestión de usuarios y empleados (roles básicos y autenticación).

---

### 🗂️ Modelo de Datos

A continuación se muestra el modelo de la base de datos diseñado para el sistema:
<img width="802" height="628" alt="image" src="https://github.com/user-attachments/assets/a4b7c82d-1ff9-4963-a4f0-3c75cb12c47e" />

---

## 📌 Endpoints Disponibles

### 🔹 Comodidad
| Método  | Endpoint            | Descripción                        |
|---------|---------------------|------------------------------------|
| GET     | `/comodidades`      | Listar todas las comodidades       |
| GET     | `/comodidades/{id}` | Obtener una comodidad por ID       |
| POST    | `/comodidades`      | Crear una nueva comodidad          |
| PUT     | `/comodidades/{id}` | Actualizar una comodidad existente |
| DELETE  | `/comodidades/{id}` | Eliminar lógicamente una comodidad | 

---

### 🔹 Estados de Habitación
| Método  | Endpoint                  | Descripción                                  |
|---------|---------------------------|----------------------------------------------|
| GET     | `/estadosHabitacion`      | Listar todos los estados de habitación       |
| GET     | `/estadosHabitacion/{id}` | Obtener un estado de habitacion por ID       |
| POST    | `/estadosHabitacion`      | Crear un nuevo estado de habitación          |
| PUT     | `/estadosHabitacion/{id}` | Actualizar un estado de habitación existente |
| DELETE  | `/estadosHabitacion/{id}` | Eliminar lógicamente un estado de habitación |

---

### 🔹 Estados de Reserva
| Método  | Endpoint               | Descripción                               |
|---------|------------------------|-------------------------------------------|
| GET     | `/estadosReserva`      | Listar todos los estados de reserva       |
| GET     | `/estadosReserva/{id}` | Obtener un estado de reserva por ID       |
| POST    | `/estadosReserva`      | Crear un nuevo estado de reserva          |
| PUT     | `/estadosReserva/{id}` | Actualizar un estado de reserva existente |
| DELETE  | `/estadosReserva/{id}` | Eliminar lógicamente un estado de reserva |

---

### 🔹 Habitaciones
| Método  | Endpoint             | Descripción                         |
|---------|----------------------|-------------------------------------|
| GET     | `/habitaciones`      | Listar todas las habitaciones       |
| GET     | `/habitaciones/{id}` | Obtener una habitacion por ID       |
| POST    | `/habitaciones`      | Crear una nueva habitación          |
| PUT     | `/habitaciones/{id}` | Actualizar una habitación existente |
| DELETE  | `/habitaciones/{id}` | Eliminar logicamente una habitación |

---

### 🔹 Habitaciones - Comodidades
| Método  | Endpoint                      | Descripción                                   |
|---------|-------------------------------|-----------------------------------------------|
| GET     | `/habitacionComodidades`      | Listar todas las habitaciones-comodidad       |
| GET     | `/habitacionComodidades/{id}` | Obtener una habitacion - comodidad por ID     |
| POST    | `/habitacionComodidades`      | Crear una nueva habitacion-comodidad          |
| PUT     | `/habitacionComodidades/{id}` | Actualizar una relación habitación-comodidad  |
| DELETE  | `/habitacionComodidades/{id}` | Eliminar logicamente una habitación-comodidad |

---

### 🔹 Métodos de Pago
| Método  | Endpoint            | Descripción                            |
|---------|---------------------|----------------------------------------|
| GET     | `/metodosPago`      | Listar todos los métodos de pago       |
| GET     | `/metodosPago/{id}` | Obtener un metodo de pago por ID       |
| POST    | `/metodosPago`      | Crear un nuevo método de pago          |
| PUT     | `/metodosPago/{id}` | Actualizar un método de pago existente |
| DELETE  | `/metodosPago/{id}` | Eliminar logicamente un método de pago |

---

### 🔹 Pagos
| Método  | Endpoint      | Descripción                  |
|---------|---------------|------------------------------|
| GET     | `/pagos`      | Listar todos los pagos       |
| GET     | `/pagos/{id}` | Obtener un pago por ID       |
| POST    | `/pagos`      | Crear un nuevo pago          |
| PUT     | `/pagos/{id}` | Actualizar un pago existente |
| DELETE  | `/pagos/{id}` | Eliminar logicamente un pago |

---

### 🔹 Reservas
| Método  | Endpoint         | Descripción                      |
|---------|------------------|----------------------------------|
| GET     | `/reservas`      | Listar tadas las reservas        |
| GET     | `/reservas/{id}` | Obtener una reserva por ID       |
| POST    | `/reservas`      | Crear una nueva reserva          |
| PUT     | `/reservas/{id}` | Actualizar una reserva existente |
| DELETE  | `/reservas/{id}` | Eliminar logicamente una reserva |

---

### 🔹 Reservas - Servicios
| Método  | Endpoint                 | Descripción                                  |
|---------|--------------------------|----------------------------------------------|
| GET     | `/reservasServicio`      | Listar todas las reservas de servicio        |
| GET     | `/reservasServicio/{id}` | Obtener una reserva de servicio por ID       |
| POST    | `/reservasServicio`      | Crear una nueva reserva de servicio          |
| PUT     | `/reservasServicio/{id}` | Actualizar una reserva de servicio existente |
| DELETE  | `/reservasServicio/{id}` | Eliminar logicamente una reserva de servicio |

---

### 🔹 Servicios
| Método  | Endpoint          | Descripción                      |
|---------|-------------------|----------------------------------|
| GET     | `/servicios`      | Listar todos los servicios       |
| GET     | `/servicios/{id}` | Obtener un servicio por ID       |
| POST    | `/servicios`      | Crear un nuevo servicio          |
| PUT     | `/servicios/{id}` | Actualizar un servicio existente |
| DELETE  | `/servicios/{id}` | Eliminar logicamente un servicio |

---

### 🔹 Tipos de Documento
| Método  | Endpoint               | Descripción                               |
|---------|------------------------|-------------------------------------------|
| GET     | `/tiposDocumento`      | Listar todos los tipos de documento       |
| GET     | `/tiposDocumento/{id}` | Obtener un tipo de documento por ID       |
| POST    | `/tiposDocumento`      | Crear un nuevo tipo de documento          |
| PUT     | `/tiposDocumento/{id}` | Actualizar un tipo de documento existente |
| DELETE  | `/tiposDocumento/{id}` | Eliminar logicamente un tipo de documento |

---

### 🔹 Tipos de Habitación
| Método  | Endpoint                | Descripción                                |
|---------|-------------------------|--------------------------------------------|
| GET     | `/tiposHabitacion`      | Listar todos los tipos de habitación       |
| GET     | `/tiposHabitacion/{id}` | Obtener un tipo de habitacion por ID       |
| POST    | `/tiposHabitacion`      | Crear un nuevo tipo de habitación          |
| PUT     | `/tiposHabitacion/{id}` | Actualizar un tipo de habitación existente |
| DELETE  | `/tiposHabitacion/{id}` | Eliminar logicamente un tipo de habitación |

---

### 🔹 Usuarios
| Método  | Endpoint         | Descripción                     |
|---------|------------------|---------------------------------|
| GET     | `/usuarios`      | Listar todos los usuarios       |
| GET     | `/usuarios/{id}` | Obtener un usuario por ID       |
| POST    | `/usuarios`      | Crear un nuevo usuario          |
| PUT     | `/usuarios/{id}` | Actualizar un usuario existente |
| DELETE  | `/usuarios/{id}` | Eliminar logicamente un usuario |

---

## Documentación Swagger
La documentación de la API se encuentra disponible a través de Swagger UI. Para habilitarla, se creó un archivo de configuración en la carpeta config llamado SwaggerConfig.
1. Asegúrate de que la aplicación esté corriendo.
2. Abrir un navegador web e ir a la ruta: http://localhost:8080/swagger-ui/index.html
3. Allí se visualiza todos los endpoints disponibles y probar las solicitudes.

## 🎥 Video de demostración:
(Enlace del video) https://www.youtube.com/watch?v=NyvebH-D0Js
