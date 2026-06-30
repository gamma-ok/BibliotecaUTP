CREATE DATABASE IF NOT EXISTS libreria_db;
USE libreria_db;

-- Tabla: Libros (Clase padre Libro + Clases Hijas)
CREATE TABLE libros (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL,
    anioPublicacion INT NOT NULL,
    tipoLibro VARCHAR(50) NOT NULL -- 'Novela', 'LibroTexto', 'Enciclopedia'
);

-- Tabla: Clientes (Clase Cliente)
CREATE TABLE clientes (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    celular VARCHAR(9) NOT NULL,
    email VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

-- Tabla: Prestamos (Clase Prestamo)
CREATE TABLE prestamos (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idCliente INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    montoPagado DOUBLE NOT NULL,
    -- Relaciones (Llaves foráneas "FK")
    FOREIGN KEY (idCliente) REFERENCES clientes(idCliente),
    FOREIGN KEY (idLibro) REFERENCES libros(idLibro)
);

select * from libros;
select * from clientes;
select * from prestamos;

INSERT INTO libros (isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro) VALUES
('978-01', 'Cien años de soledad', 'Gabriel García Márquez', 50.00, 10, 1967, 'Novela'),
('978-02', 'Cálculo Avanzado', 'James Stewart', 120.00, 5, 2015, 'LibroTexto'),
('978-03', 'Enciclopedia Británica', 'Varios', 300.00, 2, 2020, 'Enciclopedia'),
('978-04', 'La Ciudad y los Perros', 'Mario Vargas Llosa', 45.00, 8, 1963, 'Novela'),
('978-05', 'Física Universitaria', 'Sears Zemansky', 150.00, 4, 2018, 'LibroTexto');

INSERT INTO clientes (nombre, apellido, dni, celular, email, direccion) VALUES
('Juan', 'Perez', '12345678', '999888777', 'juan.perez@email.com', 'Av. Lima 123'),
('Maria', 'Lopez', '87654321', '988777666', 'maria.lopez@email.com', 'Calle Cusco 456'),
('Carlos', 'Ruiz', '11223344', '977666555', 'carlos.ruiz@email.com', 'Jr. Arequipa 789'),
('Ana', 'Gomez', '44332211', '966555444', 'ana.gomez@email.com', 'Av. Tacna 101'),
('Luis', 'Diaz', '55667788', '955444333', 'luis.diaz@email.com', 'Psje. Trujillo 202');

INSERT INTO prestamos (idCliente, idLibro, fechaPrestamo, fechaDevolucion, estado, montoPagado) VALUES
(1, 1, '2026-06-01', '2026-06-15', 'Activo', 5.00),
(2, 2, '2026-06-05', '2026-06-20', 'Devuelto', 0.00),
(3, 3, '2026-06-10', '2026-06-25', 'Vencido', 0.00),
(4, 4, '2026-06-12', '2026-06-27', 'Activo', 4.50),
(5, 5, '2026-06-15', '2026-06-30', 'Devuelto', 0.00);
