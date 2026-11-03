INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Mensual Básico', 250.00, 30);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Trimestral Pro', 650.00, 90);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Semestral VIP', 1200.00, 180);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Anual', 2200.00, 365);


INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Saraí', 'López', 'sarai.lopez@gmail.com', '4218-9321', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Marío', 'Gómez', 'mario.gomez@gmail.com', '5891-2304', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Jose', 'Pérez', 'jose.perez@gmail.com', '3145-8890', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Ana', 'Martínez', 'ana.martinez@gmail.com', '5023-4112', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Luis', 'Hernández', 'luis.hernandez@gmail.com', '4782-1596', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Carlos', 'Ramírez', 'carlos.ramirez@gmail.com', '0674-9876', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Lucía', 'Morales', 'lucia.morales@gmail.com', '4956-7109', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Fernando', 'Castillo', 'fernando.castillo@gmail.com', '9910-3173', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Sofía', 'Ruiz', 'sofia.ruiz@gmail.com', '5934-8901', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Diego', 'Ortiz', 'diego.ortiz@gmail.com', '4920-0019', true);


INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (1, 1, '2026-10-01', '2026-10-31', 'ACTIVA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (2, 2, '2026-08-01', '2026-11-01', 'ACTIVA');
