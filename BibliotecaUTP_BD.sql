-- DROP DATABASE IF EXISTS bibliotecautp_bd;
CREATE DATABASE IF NOT EXISTS BibliotecaUTP_BD;
USE BibliotecaUTP_BD;

-- TABLA: LIBROS
CREATE TABLE libros (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    precioCompra DOUBLE NOT NULL,
    precioVenta DOUBLE NOT NULL,
    cantidad INT NOT NULL,
    anioPublicacion INT NOT NULL,
    tipoLibro VARCHAR(50) NOT NULL
);

-- TABLA: PROVEEDORES
CREATE TABLE proveedores (
    idProveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    ruc VARCHAR(11) UNIQUE NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

-- TABLA: COMPRAS
CREATE TABLE compras_proveedor (
    idCompra INT AUTO_INCREMENT PRIMARY KEY,
    idProveedor INT NOT NULL,
    idLibro INT NOT NULL,
    fechaCompra DATE NOT NULL,
    cantidad INT NOT NULL,
    precioCompraUnitario DOUBLE NOT NULL,
    montoTotal DOUBLE NOT NULL,
    FOREIGN KEY (idProveedor) REFERENCES proveedores(idProveedor),
    FOREIGN KEY (idLibro) REFERENCES libros(idLibro)
);

-- TABLA: USUARIOS
CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    celular VARCHAR(9) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

-- TABLA: PRESTAMOS
CREATE TABLE prestamos (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    montoPagado DOUBLE NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idLibro) REFERENCES libros(idLibro)
);

-- Libros
INSERT INTO libros (isbn, titulo, autor, precioCompra, precioVenta, cantidad, anioPublicacion, tipoLibro) VALUES
('978-612-304-001-1', 'La ciudad y los perros', 'Mario Vargas Llosa', 35.00, 45.90, 15, 1963, 'Novela'),
('978-612-403-002-2', 'Conversación en La Catedral', 'Mario Vargas Llosa', 40.00, 55.00, 10, 1969, 'Novela'),
('978-958-001-003-3', 'Cien años de soledad', 'Gabriel García Márquez', 38.00, 49.90, 20, 1967, 'Novela'),
('978-84-376-0494-7', 'Don Quijote de la Mancha', 'Miguel de Cervantes', 45.00, 60.00, 8, 1605, 'Novela'),
('978-9972-45-005-5', 'Matemática Básica Universitaria', 'Julio César Rojas', 60.00, 75.50, 12, 2022, 'LibroTexto'),
('978-9972-46-006-6', 'Programación Java desde Cero', 'Carlos Ramírez', 65.00, 85.00, 18, 2023, 'LibroTexto'),
('978-9972-47-007-7', 'Fundamentos de Administración', 'Roberto Hernández', 55.00, 70.00, 14, 2021, 'LibroTexto'),
('978-84-670-008-8', 'Enciclopedia del Mundo Animal', 'Equipo Editorial Larousse', 90.00, 120.00, 5, 2020, 'Enciclopedia'),
('978-84-670-009-9', 'Enciclopedia Historia Universal', 'Editorial Planeta', 110.00, 150.00, 7, 2019, 'Enciclopedia'),
('978-612-490-010-0', 'Atlas Geográfico del Perú', 'Instituto Cartográfico Nacional', 70.00, 95.00, 9, 2024, 'Enciclopedia');

-- Usuarios
INSERT INTO usuarios (nombre, apellido, dni, celular, correo, direccion) VALUES
('Santiago', 'Gamarra', '74258196', '987654321', 'santiago.gamarra@gmail.com', 'Lima, Perú'),
('Carlos', 'Mendoza', '71345682', '986532147', 'carlos.mendoza@gmail.com', 'San Miguel, Lima'),
('Andrea', 'Ramírez', '75649821', '985741236', 'andrea.ramirez@gmail.com', 'Miraflores, Lima'),
('Lucía', 'Torres', '72894561', '984632159', 'lucia.torres@gmail.com', 'Surco, Lima'),
('Diego', 'Fernández', '76543218', '983214567', 'diego.fernandez@gmail.com', 'Los Olivos, Lima'),
('María', 'Quispe', '74561239', '982145673', 'maria.quispe@gmail.com', 'Ate, Lima'),
('José', 'Castillo', '73458962', '981236547', 'jose.castillo@gmail.com', 'Callao'),
('Valeria', 'Paredes', '75481236', '980365214', 'valeria.paredes@gmail.com', 'Comas, Lima'),
('Renato', 'Salazar', '76984521', '979452136', 'renato.salazar@gmail.com', 'Barranco, Lima'),
('Camila', 'Vargas', '74125896', '978563214', 'camila.vargas@gmail.com', 'Jesús María, Lima');

-- Proveedores
INSERT INTO proveedores (nombre, apellido, telefono, correo, ruc, direccion) VALUES
('Roberto', 'Mateo', '46823486', 'roberto.mateo@gmail.com', '20100012345', 'San Miguel, Lima'),
('Juan', 'Pérez', '87654321', 'juan.perez@libros.com', '20456789123', 'Cercado de Lima'),
('Ana', 'Gutiérrez', '86321547', 'ana.gutierrez@editorial.com', '20567891234', 'San Isidro, Lima'),
('Carlos', 'Flores', '85214763', 'carlos.flores@ventas.com', '20678912345', 'Miraflores, Lima'),
('Editorial', 'Santillana', '14789632', 'contacto@santillana.com', '20789123456', 'Lince, Lima'),
('Pedro', 'Ramírez', '84512367', 'pedro.ramirez@gmail.com', '20891234567', 'Breña, Lima'),
('Editorial', 'Larousse', '14632589', 'ventas@larousse.com', '20912345678', 'San Borja, Lima'),
('Mariana', 'Torres', '83654721', 'mariana.torres@gmail.com', '20123456789', 'Surquillo, Lima'),
('Luis', 'Herrera', '82365147', 'luis.herrera@gmail.com', '20234567891', 'La Victoria, Lima'),
('Nixon', 'Rojas', '42615346', 'nixon.rojas@gmail.com', '20345678912', 'Pueblo Libre, Lima');

-- Compras
INSERT INTO compras_proveedor (idProveedor, idLibro, fechaCompra, cantidad, precioCompraUnitario, montoTotal) VALUES
(1, 1, '2026-01-10', 10, 35.00, 350.00),
(2, 2, '2026-01-15', 8, 40.00, 320.00),
(3, 3, '2026-02-01', 15, 38.00, 570.00),
(4, 4, '2026-02-10', 5, 45.00, 225.00),
(5, 5, '2026-02-20', 12, 60.00, 720.00),
(6, 6, '2026-03-05', 20, 65.00, 1300.00),
(7, 7, '2026-03-15', 10, 55.00, 550.00),
(8, 8, '2026-04-01', 5, 90.00, 450.00),
(9, 9, '2026-04-12', 7, 110.00, 770.00),
(10, 10, '2026-05-01', 6, 70.00, 420.00);

-- Préstamos
INSERT INTO prestamos (idUsuario, idLibro, fechaPrestamo, fechaDevolucion, estado, montoPagado) VALUES
(1, 1, '2026-01-05', '2026-01-20', 'Devuelto', 5.00),
(2, 3, '2026-01-12', '2026-01-27', 'Devuelto', 5.00),
(3, 5, '2026-02-03', '2026-02-18', 'Devuelto', 10.00),
(4, 2, '2026-02-15', '2026-03-01', 'Pendiente', 0.00),
(5, 6, '2026-03-10', '2026-03-25', 'Devuelto', 5.00),
(6, 8, '2026-03-18', '2026-04-02', 'Pendiente', 0.00),
(7, 4, '2026-04-05', '2026-04-20', 'Devuelto', 5.00),
(8, 7, '2026-04-15', '2026-04-30', 'Retrasado', 15.00),
(9, 9, '2026-05-01', '2026-05-15', 'Devuelto', 5.00),
(10, 10, '2026-05-10', '2026-05-25', 'Pendiente', 0.00);
