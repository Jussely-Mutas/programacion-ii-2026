package com.estudiante.proyecto_gimnasio.repository;

import com.estudiante.proyecto_gimnasio.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}