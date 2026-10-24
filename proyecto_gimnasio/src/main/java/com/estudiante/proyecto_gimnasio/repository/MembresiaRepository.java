package com.estudiante.proyecto_gimnasio.repository;
import com.estudiante.proyecto_gimnasio.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

    List<Membresia> findByFechaVencimientoGreaterThanEqual(LocalDate fecha);

    List<Membresia> findByFechaVencimientoBefore(LocalDate fecha);

    List<Membresia> findByFechaVencimientoBetween(LocalDate hoy, LocalDate fechaLimite);

    @Query("SELECT SUM(m.plan.precio) FROM Membresia m WHERE m.plan.id = :planId")
    BigDecimal calcularIngresosPorPlan(@Param("planId") Long planId);
}