package com.estudiante.proyecto_gimnasio.controller;
import com.estudiante.proyecto_gimnasio.entity.Membresia;
import com.estudiante.proyecto_gimnasio.repository.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @GetMapping
    public List<Membresia> listarMembresias() {
        return membresiaRepository.findAll();
    }

    @PostMapping
    public Membresia guardarMembresia(@RequestBody Membresia membresia) {
        return membresiaRepository.save(membresia);
    }
}