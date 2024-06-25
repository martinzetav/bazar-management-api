# Bazar Management API

Este proyecto es una API desarrollada en Java utilizando Spring Boot, diseñada para gestionar las operaciones de un bazar, incluyendo la gestión de productos, ventas y clientes. La API está diseñada para ser utilizada tanto por una aplicación web como por una aplicación móvil.

## Tecnologías Utilizadas

- **Java**
- **Spring Boot**
  - **Dependencias**:
    - `Lombok`
    - `Spring Web`
    - `Spring Boot DevTools`
    - `MySQL Driver`
    - `Spring Data JPA`
- **MySQL**
  - **MySQL Workbench**
- **Postman** (para pruebas)
- **Patrón MVC**
- **Inyección de Dependencias**

## Estructura del Proyecto

El proyecto sigue el patrón de diseño MVC (Model-View-Controller) y está organizado en los siguientes paquetes:

- `model` - Contiene las clases de modelo para `Producto`, `Venta` y `Cliente`.
- `service` - Contiene las interfaces y las implementaciones de los servicios para gestionar la lógica de negocio.
- `repository` - Contiene las interfaces de repositorio que extienden `JpaRepository` para interactuar con la base de datos.
- `dto` - Contiene las clases Data Transfer Object (DTO) para la transferencia de datos.
- `controller` - Contiene los controladores que manejan las solicitudes HTTP.

## Modelado

### Producto
- `Long codigo_producto`
- `String nombre`
- `String marca`
- `Double costo`
- `Double cantidad_disponible`

### Venta
- `Long codigo_venta`
- `LocalDate fechaVenta`
- `Double total`
- `List<Producto> listaProductos`
- `Cliente unCliente`

### Cliente
- `Long id_cliente`
- `String nombre`
- `String apellido`
- `String dni`

## Requerimientos

### CRUD de Productos

- **Creación**: `POST /productos/crear`
- **Lista completa**: `GET /productos`
- **Obtener un producto**: `GET /productos/{codigo_producto}`
- **Eliminación**: `DELETE /productos/eliminar/{codigo_producto}`
- **Edición**: `PUT /productos/editar/{codigo_producto}`

### CRUD de Clientes

- **Creación**: `POST /clientes/crear`
- **Lista completa**: `GET /clientes`
- **Obtener un cliente**: `GET /clientes/{id_cliente}`
- **Eliminación**: `DELETE /clientes/eliminar/{id_cliente}`
- **Edición**: `PUT /clientes/editar/{id_cliente}`

### CRUD de Ventas

- **Creación**: `POST /ventas/crear`
- **Lista completa**: `GET /ventas`
- **Obtener una venta**: `GET /ventas/{codigo_venta}`
- **Eliminación**: `DELETE /ventas/eliminar/{codigo_venta}`
- **Edición**: `PUT /ventas/editar/{codigo_venta}`

### Funcionalidades Adicionales

1. **Productos con baja cantidad**: `GET /productos/falta_stock`
2. **Productos de una venta específica**: `GET /ventas/productos/{codigo_venta}`
3. **Sumatoria del monto y cantidad de ventas de un día**: `GET /ventas/{fecha_venta}`
4. **Venta con el monto más alto**: `GET /ventas/mayor_venta`
