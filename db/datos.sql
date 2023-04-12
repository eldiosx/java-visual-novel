CREATE TABLE Persona (
DNI VARCHAR(10) PRIMARY KEY,
Nombre VARCHAR(100) NOT NULL,
Apellidos VARCHAR(100) NOT NULL,
Telefono int NOT NULL,
Email VARCHAR(100) NOT NULL
)

INSERT INTO Persona (DNI, Nombre, Apellidos, Telefono, Email) VALUES ('14786325P', 'Juan', 'López López', 666666666, 'juanlopez@gmail.com');
INSERT INTO Persona (DNI, Nombre, Apellidos, Telefono, Email) VALUES ('24158749L', 'Pepe', 'Adamuz Núñez', 666956666, 'pepeadamuz@gmail.com');
INSERT INTO Persona (DNI, Nombre, Apellidos, Telefono, Email) VALUES ('36214758I', 'Dolores', 'Pérez Aguilera', 684766666, 'doloresperez@gmail.com');