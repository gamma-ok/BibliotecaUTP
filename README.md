# Sistema de Gestión de Librería

## Descripción
Este proyecto es una aplicación de escritorio desarrollada en Java que permite la gestión eficiente de los procesos fundamentales de una librería. El sistema sigue el patrón de arquitectura **MVC (Modelo-Vista-Controlador)** y garantiza la integridad de los datos mediante validaciones robustas y el manejo correcto de relaciones entre entidades (Clientes, Libros y Préstamos).

## Características Principales
* **Gestión de Clientes:** Registro, edición, búsqueda y eliminación con validación de datos (DNI, celular, email).
* **Gestión de Libros:** Control de inventario con clasificación de tipos (Libro de Texto, Novela, Enciclopedia) utilizando **polimorfismo** para el cálculo de precios.
* **Gestión de Préstamos:** Control de fechas, estados de préstamo y asociación dinámica entre clientes y libros.
* **Integridad de Datos:** Manejo de excepciones para evitar errores de clave foránea (FK) y garantizar que no se eliminen registros en uso.
* **Arquitectura MVC:** Separación clara de responsabilidades entre la lógica de negocio, la persistencia de datos (DAO) y la interfaz gráfica (Swing).

## Estructura del Proyecto
- `libreria.modelo`: Entidades y lógica de negocio.
- `libreria.datos`: Clases DAO para comunicación con MySQL.
- `libreria.controlador`: Gestión de eventos y lógica de conexión.
- `libreria.vista`: Interfaz gráfica.

## Diagrama UML
![Diagrama UML](src/libreria/recursos/Diagrama%20UML%20-%20Libreria.jpg)

## Instalación y Configuración
1. Clona este repositorio:
   ```bash
   git clone [https://github.com/gamma-ok/Libreria-UTP.git](https://github.com/gamma-ok/Libreria-UTP.git)
