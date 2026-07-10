-- DROP DATABASE IF EXISTS bibliotecautp_bd;
CREATE DATABASE IF NOT EXISTS BibliotecaUTP_BD;
USE BibliotecaUTP_BD;

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
CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    celular VARCHAR(9) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

-- Tabla: Proveedores
CREATE TABLE proveedores (
    idProveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    ruc VARCHAR(11) UNIQUE NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

-- Tabla: CompraProveedor (Nexo)
CREATE TABLE compras_proveedor (
    idCompra INT AUTO_INCREMENT PRIMARY KEY,
    idProveedor INT NOT NULL,
    idLibro INT NOT NULL,
    fechaEntrega DATE NOT NULL,
    cantidad INT NOT NULL,
    precioUnitario DOUBLE NOT NULL,
    montoTotal DOUBLE NOT NULL,
    FOREIGN KEY (idProveedor) REFERENCES proveedores(idProveedor),
    FOREIGN KEY (idLibro) REFERENCES libros(idLibro)
);

-- Tabla: Prestamos (Clase Prestamo)
CREATE TABLE prestamos (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idUsuario INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    montoPagado DOUBLE NOT NULL,
    -- Relaciones (Llaves foráneas "FK")
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idLibro) REFERENCES libros(idLibro)
);

select * from libros;
select * from usuarios;
select * from prestamos;

INSERT INTO libros (isbn, titulo, autor, precio, stock, anioPublicacion, tipoLibro) VALUES
('978-01', 'Cien años de soledad', 'Gabriel García Márquez', 50.00, 10, 1967, 'Novela'),
('978-02', 'Cálculo Avanzado', 'James Stewart', 120.00, 5, 2015, 'LibroTexto'),
('978-03', 'Enciclopedia Británica', 'Varios', 300.00, 2, 2020, 'Enciclopedia'),
('978-04', 'La Ciudad y los Perros', 'Mario Vargas Llosa', 45.00, 8, 1963, 'Novela'),
('978-05', 'Física Universitaria', 'Sears Zemansky', 150.00, 4, 2018, 'LibroTexto'),
('978-06', 'Don Quijote de la Mancha', 'Miguel de Cervantes', 60.00, 12, 1605, 'Novela'),
('978-07', 'Álgebra Lineal', 'Gilbert Strang', 90.00, 7, 2016, 'LibroTexto'),
('978-08', 'Enciclopedia de Historia', 'National Geographic', 250.00, 3, 2021, 'Enciclopedia'),
('978-09', 'Crimen y Castigo', 'Fiódor Dostoyevski', 55.00, 6, 1866, 'Novela'),
('978-10', 'Ecuaciones Diferenciales', 'Dennis Zill', 110.00, 5, 2017, 'LibroTexto'),
('978-11', 'Enciclopedia del Espacio', 'NASA', 280.00, 2, 2022, 'Enciclopedia'),
('978-12', 'El Principito', 'Antoine de Saint-Exupéry', 30.00, 20, 1943, 'Novela');

INSERT INTO usuarios (nombre, apellido, dni, celular, correo, direccion) VALUES
('Juan', 'Perez', '10000001', '900000001', 'u1@email.com', 'Av. Lima 1'),
('Maria', 'Lopez', '10000002', '900000002', 'u2@email.com', 'Av. Lima 2'),
('Carlos', 'Ruiz', '10000003', '900000003', 'u3@email.com', 'Av. Lima 3'),
('Ana', 'Gomez', '10000004', '900000004', 'u4@email.com', 'Av. Lima 4'),
('Luis', 'Diaz', '10000005', '900000005', 'u5@email.com', 'Av. Lima 5'),
('Elena', 'Torres', '10000006', '900000006', 'u6@email.com', 'Av. Lima 6'),
('Jorge', 'Silva', '10000007', '900000007', 'u7@email.com', 'Av. Lima 7'),
('Sofia', 'Rojas', '10000008', '900000008', 'u8@email.com', 'Av. Lima 8'),
('Pedro', 'Vargas', '10000009', '900000009', 'u9@email.com', 'Av. Lima 9'),
('Lucia', 'Castro', '10000010', '900000010', 'u10@email.com', 'Av. Lima 10'),
('Miguel', 'Vega', '10000011', '900000011', 'u11@email.com', 'Av. Lima 11'),
('Rosa', 'Mendoza', '10000012', '900000012', 'u12@email.com', 'Av. Lima 12');

INSERT INTO proveedores (nombre, apellido, telefono, correo, ruc, direccion) VALUES
('Proveedor', 'A', '910000001', 'p1@prov.com', '20000000001', 'Calle A 1'),
('Proveedor', 'B', '910000002', 'p2@prov.com', '20000000002', 'Calle A 2'),
('Proveedor', 'C', '910000003', 'p3@prov.com', '20000000003', 'Calle A 3'),
('Proveedor', 'D', '910000004', 'p4@prov.com', '20000000004', 'Calle A 4'),
('Proveedor', 'E', '910000005', 'p5@prov.com', '20000000005', 'Calle A 5'),
('Proveedor', 'F', '910000006', 'p6@prov.com', '20000000006', 'Calle A 6'),
('Proveedor', 'G', '910000007', 'p7@prov.com', '20000000007', 'Calle A 7'),
('Proveedor', 'H', '910000008', 'p8@prov.com', '20000000008', 'Calle A 8'),
('Proveedor', 'I', '910000009', 'p9@prov.com', '20000000009', 'Calle A 9'),
('Proveedor', 'J', '910000010', 'p10@prov.com', '20000000010', 'Calle A 10'),
('Proveedor', 'K', '910000011', 'p11@prov.com', '20000000011', 'Calle A 11'),
('Proveedor', 'L', '910000012', 'p12@prov.com', '20000000012', 'Calle A 12');

INSERT INTO compras_proveedor (idProveedor, idLibro, fechaEntrega, cantidad, precioUnitario, montoTotal) VALUES
(1, 1, '2026-01-01', 5, 40.0, 200.0), (2, 2, '2026-01-02', 3, 100.0, 300.0),
(3, 3, '2026-01-03', 2, 250.0, 500.0), (4, 4, '2026-01-04', 10, 35.0, 350.0),
(5, 5, '2026-01-05', 4, 130.0, 520.0), (6, 6, '2026-01-06', 2, 50.0, 100.0),
(7, 7, '2026-01-07', 6, 80.0, 480.0), (8, 8, '2026-01-08', 2, 200.0, 400.0),
(9, 9, '2026-01-09', 5, 45.0, 225.0), (10, 10, '2026-01-10', 3, 90.0, 270.0),
(11, 11, '2026-01-11', 1, 250.0, 250.0), (12, 12, '2026-01-12', 15, 20.0, 300.0);

INSERT INTO prestamos (idUsuario, idLibro, fechaPrestamo, fechaDevolucion, estado, montoPagado) VALUES
(1, 1, '2026-02-01', '2026-02-15', 'Devuelto', 5.0), (2, 2, '2026-02-02', '2026-02-16', 'Activo', 12.0),
(3, 3, '2026-02-03', '2026-02-17', 'Vencido', 30.0), (4, 4, '2026-02-04', '2026-02-18', 'Devuelto', 4.5),
(5, 5, '2026-02-05', '2026-02-19', 'Activo', 15.0), (6, 6, '2026-02-06', '2026-02-20', 'Devuelto', 6.0),
(7, 7, '2026-02-07', '2026-02-21', 'Activo', 9.0), (8, 8, '2026-02-08', '2026-02-22', 'Devuelto', 25.0),
(9, 9, '2026-02-09', '2026-02-23', 'Activo', 5.5), (10, 10, '2026-02-10', '2026-02-24', 'Devuelto', 11.0),
(11, 11, '2026-02-11', '2026-02-25', 'Activo', 28.0), (12, 12, '2026-02-12', '2026-02-26', 'Devuelto', 3.0);
