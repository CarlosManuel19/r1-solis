-- Crear la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS db_reto1;

-- Utilizar la base de datos recién creada
USE db_reto1;

-- Crear la tabla "cuentas"
CREATE TABLE cuentas (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(255),
    numero_cuenta VARCHAR(255),
    saldo DECIMAL(10, 2),
    estado TINYINT(1)
);

-- Registro 1
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('John Smith', '12345', 5000.00, 1);

-- Registro 2
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('Alice Johnson', '67890', 7500.50, 1);

-- Registro 3
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('Robert Davis', '24680', 3200.25, 1);

-- Registro 4
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('Maria Garcia', '13579', 10000.75, 1);

-- Registro 5
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('James Wilson', '98765', 1500.00, 1);

-- Registro 6
INSERT INTO cuentas (nombre_cliente, numero_cuenta, saldo, estado)
VALUES ('Emily Brown', '54321', 4200.00, 1);
