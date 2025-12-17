DROP DATABASE IF EXISTS RetoThreeCode;

CREATE DATABASE IF NOT EXISTS RetoThreeCode;

USE RetoThreeCode;

DROP TABLE IF EXISTS Gestor;
DROP TABLE IF EXISTS Viaje;
DROP TABLE IF EXISTS Paquete;
DROP TABLE IF EXISTS Camion;
DROP TABLE IF EXISTS Camionero;
DROP TABLE IF EXISTS Empleado;

CREATE TABLE Empleado (
    ID_empleado INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    DNI VARCHAR(15) UNIQUE NOT NULL,
    Direccion VARCHAR(100),
    Telefono VARCHAR(20)
);

CREATE TABLE Camionero (
    ID_camionero INT PRIMARY KEY,
    Carnet_conducir VARCHAR(20) NOT NULL,
    FOREIGN KEY (ID_camionero) REFERENCES Empleado(ID_empleado)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Camion (
    ID_camion INT AUTO_INCREMENT PRIMARY KEY,
    Matricula_camion VARCHAR(15) UNIQUE NOT NULL,
    Modelo_camion VARCHAR(50) NOT NULL,
    Capacidad_camion DECIMAL(10,2) NOT NULL
);

CREATE TABLE Paquete (
    ID_paquete INT AUTO_INCREMENT PRIMARY KEY,
    Peso_paquete DECIMAL(10,2) NOT NULL,
    Dimensiones_paquete VARCHAR(50),
    Remitente VARCHAR(100) NOT NULL,
    Destinatario VARCHAR(100) NOT NULL
);

CREATE TABLE Viaje (
    ID_viaje INT AUTO_INCREMENT PRIMARY KEY,
    Fecha_hora_salida DATETIME NOT NULL,
    Ciudad_salida VARCHAR(100) NOT NULL,
    Ciudad_destino VARCHAR(100) NOT NULL,
    Kilometraje DECIMAL(10,2),
    Estado VARCHAR(30),
    ID_paquete INT,
    ID_camion INT,
    ID_camionero INT,
    FOREIGN KEY (ID_paquete) REFERENCES Paquete(ID_paquete)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (ID_camion) REFERENCES Camion(ID_camion)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (ID_camionero) REFERENCES Camionero(ID_camionero)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE Gestor (
    ID_gestor INT PRIMARY KEY,
    Departamento VARCHAR(50) NOT NULL,
    ID_viaje INT,
    FOREIGN KEY (ID_gestor) REFERENCES Empleado(ID_empleado)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (ID_viaje) REFERENCES Viaje(ID_viaje)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

SELECT * 
FROM Empleado;

SELECT * 
FROM Empleado
WHERE Nombre = 'Unai';

SELECT * 
FROM Empleado
WHERE DNI = '12345678A';

SELECT * 
FROM Viaje 
WHERE ID_camion = 1;

SELECT * 
FROM Paquete 
WHERE Remitente = 'Empresa X';

SELECT * 
FROM Paquete 
WHERE Destinatario = 'Cliente Y';

SELECT * 
FROM Camion
WHERE Capacidad_camion > 0;

SELECT * 
FROM Viaje
WHERE ID_camionero = 1;

SELECT E.Nombre, E.Apellido, V.Ciudad_salida, V.Ciudad_destino 
FROM Gestor G
JOIN Empleado E ON G.ID_gestor = E.ID_empleado
JOIN Viaje V ON G.ID_viaje = V.ID_viaje;

SELECT * 
FROM Viaje
WHERE Kilometraje = (SELECT MAX(Kilometraje) FROM Viaje);

SELECT COUNT(*) AS Total_paquetes
FROM Paquete;

SELECT ID_camionero, COUNT(ID_viaje) AS Numero_de_viajes
FROM Viaje
GROUP BY ID_camionero
ORDER BY Numero_de_viajes DESC
LIMIT 1;

SELECT SUM(Peso_paquete) AS Peso_total
FROM Paquete P
JOIN Viaje V ON P.ID_paquete = V.ID_paquete
WHERE V.ID_viaje = 1;

SELECT COUNT(*) AS Numero_de_viajes
FROM Viaje
WHERE YEAR(Fecha_hora_salida) = 2025;

SELECT COUNT(*) AS Numero_de_viajes
FROM Viaje
WHERE YEAR(Fecha_hora_salida) = 2025 AND MONTH(Fecha_hora_salida) = 12;

SELECT * 
FROM Viaje
WHERE Kilometraje > (SELECT AVG(Kilometraje) FROM Viaje);