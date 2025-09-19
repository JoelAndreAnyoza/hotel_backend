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
- JPA / Hibernate
- Postman

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

### Exclusiones (fuera del alcance)

- No incluye frontend web ni móvil (solo API backend).
- No se conecta a pasarelas de pago reales (solo simulación).
- No tiene dashboards ni reportes avanzados.

### Modelo de Datos

A continuación se muestra el modelo de la base de datos diseñado para el sistema:

![Modelo de datos](C:\javaSpring\hotel_backend\src\main\resources\static\HotelDB.png)
<img width="711" height="612" alt="image" src="https://github.com/user-attachments/assets/61806804-6296-4df4-ae67-9ef342083468" />

