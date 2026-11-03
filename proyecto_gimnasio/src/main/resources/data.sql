INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Mensual Básico', 250.00, 30);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Trimestral Pro', 650.00, 90);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Semestral VIP', 1200.00, 180);
INSERT INTO plan (nombre, precio, duracion_dias) VALUES ('Plan Anual', 2200.00, 365);

INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Saraí', 'López', 'sarai.lopez@email.com', '4218-9321', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Mario', 'Gómez', 'mario.gomez@email.com', '5891-2304', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Jose', 'Pérez', 'jose.perez@email.com', '3145-8898', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Ana', 'Martínez', 'ana.martinez@email.com', '5023-4112', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Luis', 'Hernández', 'luis.hernandez@email.com', '4782-1596', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Carlos', 'Ramírez', 'carlos.ramirez@email.com', '0674-9876', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Lucía', 'Morales', 'lucia.morales@email.com', '4956-7109', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Fernando', 'Castillo', 'fernando.castillo@email.com', '9910-3173', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Sofía', 'Ruiz', 'sofia.ruiz@email.com', '5934-8981', true);
INSERT INTO clientes (nombre, apellido, correo, telefono, activo) VALUES ('Diego', 'Ortíz', 'diego.ortiz@email.com', '4920-0019', true);

INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (1, 1, '2026-10-01', '2026-10-31', 'ACTIVA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (2, 2, '2026-08-01', '2026-11-01', 'ACTIVA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (3, 1, '2026-01-01', '2026-02-01', 'VENCIDA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (4, 2, '2026-02-01', '2026-05-01', 'VENCIDA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (5, 3, '2026-03-10', '2026-04-10', 'VENCIDA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (6, 1, '2026-05-15', '2026-11-15', 'ACTIVA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (7, 2, '2026-06-01', '2026-09-01', 'VENCIDA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (8, 1, '2026-08-01', '2026-09-01', 'VENCIDA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (9, 3, '2026-09-10', '2026-12-10', 'ACTIVA');
INSERT INTO membresia (cliente_id, plan_id, fecha_inicio, fecha_vencimiento, estado) VALUES (10, 2, '2026-10-01', '2027-01-01', 'ACTIVA');

