CREATE DATABASE RENTACAR;

\c RENTACAR;

CREATE TABLE CLASES_VEHICULOS (
    cod char primary key,
    nombre varchar(12),
    descripcion text
);

CREATE TABLE VEHICULOS (
    matricula varchar(7) primary key,
    marca varchar(20),
    modelo varchar(20),
    clase char(1) REFERENCES CLASES_VEHICULOS (cod),
    precioDia decimal(5,2)
);

CREATE TABLE ESPECIFICACIONES_COCHES (
    matricula varchar(7) primary key references vehiculos (matricula),
    numeroPuertas smallint,
    potenciaMotor smallint
);

CREATE TABLE ESPECIFICACIONES_MOTOS (
    matricula varchar(7) primary key references vehiculos (matricula),
    cilindrada smallint
);

CREATE TABLE ESPECIFICACIONES_CARAVANAS (
    matricula varchar(7) primary key references vehiculos (matricula),
    potenciaMotor smallint,
    wc boolean
);

CREATE TABLE ROLES (
    id serial primary key,
    nombre varchar(20)
);

CREATE TABLE CLIENTES (
    NIF varchar(10) primary key,
    nombre varchar(20),
    apellido1 varchar(20),
    apellido2 varchar(20),
    telefono varchar(13),
    email text
);

CREATE TABLE USUARIOS (
    usuario text primary key,
    password text,
    clienteNIF varchar(10) REFERENCES CLIENTES (NIF),
    rolId int REFERENCES ROLES (id)
);

CREATE TABLE RESERVAS (
    numReserva varchar(8) primary key,
    fechaSolicitud date,
    fechaRecogida date,
    horaRecogida time,
    fechaDevolucion date,
    horaDevolucion time,
    observaciones text,
    clienteNIF varchar(10) REFERENCES CLIENTES (NIF)
);

CREATE TABLE DETALLES_RESERVA (
    id serial,
    numReserva varchar(8) REFERENCES RESERVAS (numReserva),
    matriculaVehiculo varchar(7) REFERENCES VEHICULOS (matricula),
    precioDia decimal(8,2),
    descuento decimal(5,2)
);

--encriptamos la password
--mas info en https://x-team.com/blog/storing-secure-passwords-with-postgresql/
CREATE EXTENSION pgcrypto;

INSERT INTO USUARIOS (usuario, password,rolId) VALUES (
  'admin',
  crypt('admin123', gen_salt('bf')),
  2
);

INSERT INTO ROLES (nombre) VALUES ('cliente'),('administrador');

INSERT INTO CLASES_VEHICULOS VALUES ('A','GAMA MEDIA','COCHE DE GAMA MEDIA, TIPO FAMILIAR'),
('B','GAMA BASIC','MOTO SCOOTER'), ('C','GAMA SUPER','CARAVANA CON WC 3 PLAZAS');

--VEHICULO DE TEST
INSERT INTO VEHICULOS VALUES ('1234SS','ford','fiesta','A',100);