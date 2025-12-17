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