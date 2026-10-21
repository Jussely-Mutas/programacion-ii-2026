package com.estudiante.proyecto_gimnasio.controller;
import com.estudiante.proyecto_gimnasio.entity.Inscripcion;
import com.estudiante.proyecto_gimnasio.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @GetMapping
    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    @PostMapping
    public Inscripcion guardarInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }
}