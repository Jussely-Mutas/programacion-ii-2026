package com.estudiante.proyecto_gimnasio.repository;
import com.estudiante.proyecto_gimnasio.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
}