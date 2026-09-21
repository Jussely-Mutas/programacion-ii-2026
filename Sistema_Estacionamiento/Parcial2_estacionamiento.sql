CREATE DATABASE parcial2_estacionamiento;

CREATE TABLE vehiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(20) NOT NULL UNIQUE,
    propietario VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    hora_ingreso VARCHAR(10) NOT NULL,
    horas_utilizadas NUMERIC(5,2) NOT NULL CHECK (horas_utilizadas > 0),
    costo NUMERIC(10,2) NOT NULL CHECK (costo >= 0),
    activo BOOLEAN DEFAULT TRUE
);


INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo) VALUES 
('P-123ABC', 'Juan Pérez', 'Automóvil', '08:00', 3, 30.00),
('M-456DEF', 'María López', 'Motocicleta', '09:15', 6, 32.40),
('P-789GHI', 'Carlos Gómez', 'Automóvil', '10:00', 6, 54.00),
('M-101JKL', 'Ana Martínez', 'Motocicleta', '11:30', 2, 12.00),
('P-202MNO', 'Luis Hernández', 'Automóvil', '12:00', 1, 10.00);


SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo FROM vehiculo;

SELECT * FROM vehiculo WHERE tipo = 'Automóvil';


SELECT * FROM vehiculo WHERE costo > 30.00;


SELECT * FROM vehiculo ORDER BY costo DESC;

UPDATE vehiculo SET propietario = 'Juan Carlos Pérez' WHERE placa = 'P-123ABC';

UPDATE vehiculo SET activo = FALSE WHERE placa = 'M-101JKL';

DELETE FROM vehiculo WHERE placa = 'P-202MNO';
