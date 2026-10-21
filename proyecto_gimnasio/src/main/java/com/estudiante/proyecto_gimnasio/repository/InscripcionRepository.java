package com.estudiante.proyecto_gimnasio.repository;

import com.estudiante.proyecto_gimnasio.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}