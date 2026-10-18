package com.estudiante.biblioteca.api.repository;
import com.estudiante.biblioteca.api.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByCategoriaIgnoreCase(String categoria);
    List<Libro> findByDisponibleTrue();
}