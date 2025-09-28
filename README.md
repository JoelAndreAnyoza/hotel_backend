# Hotel Management API

Backend desarrollado en _Java Spring Boot_ para la gestión de un hotel.  
Permite administrar **habitaciones, reservas, clientes, empleados, pagos y servicios extras**.

---

## Integrantes

- Alarcón Noe Sebastián
- Anyoza Joel André

---

## Tecnologías utilizadas

- Java 24
- Spring Boot 3.5.5
- Maven
- PostgreSQL
- JPA
- Postman
- Swagger

---

## Alcance

El sistema tiene como finalidad **gestionar las operaciones principales de un hotel**, centradas en el lado **backend** (servicios y base de datos).

### Funcionalidades incluidas

- Gestión de habitaciones (registro, tipos, disponibilidad, precios).
- Gestión de clientes (datos personales y contacto).
- Gestión de reservas (crear, consultar, modificar, estados).
- Pagos (registro, métodos de pago, historial).
- Servicios extras (spa, lavandería, transporte) y su asociación a reservas.
- Gestión de usuarios y empleados (roles básicos y autenticación).

### Acceso a la documentación Swagger
La documentación de la API se encuentra disponible a través de Swagger UI. Para habilitarla, se creó un archivo de configuración en la carpeta config llamado SwaggerConfig.
1. Asegúrate de que la aplicación esté corriendo.
2. Abrir un navegador web e ir a la ruta: http://localhost:8080/swagger-ui/index.html
3. Allí se visualiza todos los endpoints disponibles y probar las solicitudes.

### Exclusiones (fuera del alcance)

- No incluye frontend web ni móvil (solo API backend).
- No se conecta a pasarelas de pago reales (solo simulación).
- No tiene dashboards ni reportes avanzados.

### Modelo de Datos

A continuación se muestra el modelo de la base de datos diseñado para el sistema:

![Modelo de datos](C:\javaSpring\hotel_backend\src\main\resources\static\HotelDB.png)
<img width="802" height="628" alt="image" src="https://github.com/user-attachments/assets/a4b7c82d-1ff9-4963-a4f0-3c75cb12c47e" />


