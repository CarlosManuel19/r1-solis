# Construcción de api rest utilizando java (spring boot), maven y MySQL

Esta API proporciona operaciones fundamentales que permiten consultar, crear, modificar y eliminar cuentas.

## Instalación

#### Requisitos previos
-Java
-MySQL
-Maven
-Postman

## Crear el proyecto con Spring Initializr
-Ve a Spring Initializr para generar un proyecto Spring Boot.
-Selecciona las dependencias necesarias
-Descarga y extrae el proyecto ZIP generado


## Configuración de la base de datos
Edita el archivo application.properties con tus credenciales de MySQL

## Carpetas del proyecto
#### controller: Contiene los controladores que manejan las solicitudes HTTP y las respuestas.
#### model: Contiene los modelos de datos (dao, dto, entidad y payload).
#### service: Contiene la lógica de negocio, dividida en interfaces y su implementación

## Uso de la API (solicitud y respuesta)

1. Mostrar cuentas
   GET http://localhost:8080/api/v1/accounts

2. Crear una nueva cuenta
   POST http://localhost:8080/api/v1/accounts

3. Actualizar una cuenta
   PUT http://localhost:8080/api/v1/accounts/{id}

4. Desactivar una
   DELETE http://localhost:8080/api/v1/accounts/{id}






## Script de la base de datos

```
create database db_springboot_dev;
CREATE TABLE `db_springboot_dev`.`clientes` (
  `id_cliente` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fecha_registro` date  NOT NULL,
  PRIMARY KEY (`id_cliente`));
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Joel', 'Jurado', 'juradoec@yahoo.com', '2023-08-01');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Carlos', 'Miranda', 'mirandaTr98@gmail.com', '2023-08-02');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Marcela', 'Sanchez', 'schMarce@itb.com', '2023-08-03');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');
```