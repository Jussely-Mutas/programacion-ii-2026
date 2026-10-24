package com.estudiante.proyecto_gimnasio.controller;
import com.estudiante.proyecto_gimnasio.dto.MembresiaRequestDTO;
import com.estudiante.proyecto_gimnasio.entity.Membresia;
import com.estudiante.proyecto_gimnasio.service.MembresiaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    private final MembresiaService membresiaService;

    public MembresiaController(MembresiaService membresiaService) {
        this.membresiaService = membresiaService;
    }

    @PostMapping
    public ResponseEntity<Membresia> registrar(@Valid @RequestBody MembresiaRequestDTO dto) {
        Membresia nuevaMembresia = membresiaService.registrarMembresia(dto);
        return new ResponseEntity<>(nuevaMembresia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Membresia>> listarTodas() {
        return ResponseEntity.ok(membresiaService.obtenerTodas());
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Membresia>> listarActivas() {
        return ResponseEntity.ok(membresiaService.obtenerActivas());
    }

    @GetMapping("/vencidas")
    public ResponseEntity<List<Membresia>> listarVencidas() {
        return ResponseEntity.ok(membresiaService.obtenerVencidas());
    }

    @GetMapping("/proximas-a-vencer")
    public ResponseEntity<List<Membresia>> listarProximasAVencer(@RequestParam(defaultValue = "7") int dias) {
        return ResponseEntity.ok(membresiaService.obtenerProximasAVencer(dias));
    }

    @GetMapping("/ingresos/plan/{planId}")
    public ResponseEntity<BigDecimal> obtenerIngresosPorPlan(@PathVariable Long planId) {
        return ResponseEntity.ok(membresiaService.obtenerIngresosPorPlan(planId));
    }
}