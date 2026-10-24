package com.estudiante.proyecto_gimnasio.controller;
import com.estudiante.proyecto_gimnasio.dto.PlanRequestDTO;
import com.estudiante.proyecto_gimnasio.entity.Plan;
import com.estudiante.proyecto_gimnasio.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<Plan> crearPlan(@Valid @RequestBody PlanRequestDTO dto) {
        Plan nuevoPlan = planService.crearPlan(dto);
        return new ResponseEntity<>(nuevoPlan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Plan>> listarPlanes() {
        return ResponseEntity.ok(planService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> obtenerPlanPorId(@PathVariable Long id) {
        return ResponseEntity.ok(planService.obtenerPorId(id));
    }
}