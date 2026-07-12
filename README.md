# Sistema de Gestión de Biblioteca

## Descripción
Este proyecto es una aplicación de escritorio desarrollada en Java que permite la gestión de los procesos de una biblioteca. El sistema sigue el patrón de arquitectura MVC (Modelo-Vista-Controlador) y garantiza la integridad de los datos mediante validaciones y el manejo correcto de relaciones entre entidades (Usuarios, Libros, Proveedores, Compras y Préstamos).

## Características Principales
* **Gestión de Usuarios:** Registro, edición, búsqueda y eliminación con validación de datos (DNI, celular, correo).
* **Gestión de Proveedores:** Registro, edición, búsqueda y eliminación con validación de datos (RUC, teléfono, correo).
* **Gestión de Libros:** Control de inventario con clasificación de tipos (LibroTexto, Novela, Enciclopedia) utilizando polimorfismo para el cálculo de precios.
* **Gestión de Compras:** Registro de compras a proveedores con actualización automática del stock y precio de compra promedio.
* **Gestión de Préstamos:** Control de fechas, estados de préstamo (Activo, Devuelto, Vencido) y asociación entre usuarios y libros.
* **Integridad de Datos:** Manejo de excepciones para evitar errores de clave foránea (FK) y garantizar que no se eliminen registros en uso.
* **Arquitectura MVC:** Separación de responsabilidades entre la lógica de negocio, la persistencia de datos (DAO) y la interfaz gráfica (Swing).

## Estructura del Proyecto
- `biblioteca.modelo`: Entidades y lógica de negocio (Usuario, Proveedor, Libro, Prestamo, CompraProveedor).
- `biblioteca.datos`: Clases DAO para comunicación con MySQL.
- `biblioteca.controlador`: Gestión de eventos y lógica de conexión entre vista y modelo.
- `biblioteca.vista`: Interfaz gráfica (Swing) con los formularios de gestión.
- `biblioteca.recursos`: Recursos gráficos (iconos, imágenes, fondo).

## Diagrama UML
![Diagrama UML](BibliotecaUTP/src/biblioteca/recursos/Diagrama%20UML%20-%20Biblioteca.jpg)

## Instalación y Configuración
1. Clona este repositorio:
   ```bash
   git clone [https://github.com/gamma-ok/BibliotecaUTP.git](https://github.com/gamma-ok/BibliotecaUTP.git)
