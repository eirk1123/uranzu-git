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