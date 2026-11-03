DROP TABLE IF EXISTS membresia CASCADE;
DROP TABLE IF EXISTS plan CASCADE;
DROP TABLE IF EXISTS clientes CASCADE;

CREATE TABLE clientes (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL,
                          correo VARCHAR(150) NOT NULL UNIQUE,
                          telefono VARCHAR(20) NOT NULL,
                          activo BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE plan (
                      id BIGSERIAL PRIMARY KEY,
                      nombre VARCHAR(100) NOT NULL,
                      precio NUMERIC(10, 2) NOT NULL,
                      duracion_dias INT NOT NULL
);

CREATE TABLE membresia (
                           id BIGSERIAL PRIMARY KEY,
                           cliente_id BIGINT NOT NULL,
                           plan_id BIGINT NOT NULL,
                           fecha_inicio DATE NOT NULL,
                           fecha_vencimiento DATE NOT NULL,
                           estado VARCHAR(50) NOT NULL,
                           CONSTRAINT fk_membresia_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE,
                           CONSTRAINT fk_membresia_plan FOREIGN KEY (plan_id) REFERENCES plan(id) ON DELETE CASCADE
);