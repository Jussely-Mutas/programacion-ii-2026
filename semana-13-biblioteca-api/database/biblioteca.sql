CREATE TABLE libro (
                       id BIGSERIAL PRIMARY KEY,
                       codigo VARCHAR(20) NOT NULL UNIQUE,
                       titulo VARCHAR(120) NOT NULL,
                       autor VARCHAR(100) NOT NULL,
                       categoria VARCHAR(50) NOT NULL,
                       anio_publicacion INTEGER NOT NULL CHECK (anio_publicacion > 0),
                       precio NUMERIC(8, 2) NOT NULL CHECK (precio > 0),
                       disponible BOOLEAN NOT NULL DEFAULT TRUE
);