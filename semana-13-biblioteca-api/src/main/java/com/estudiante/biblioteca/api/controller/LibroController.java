package com.estudiante.biblioteca.api.controller;
import com.estudiante.biblioteca.api.entity.Libro;
import com.estudiante.biblioteca.api.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository libroRepository;
    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodos() {
        List<Libro> libros = libroRepository.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        return libroOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Libro> registrar(@RequestBody Libro libro) {
        Libro libroGuardado = libroRepository.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            Libro libroExistente = libroOptional.get();
            libroExistente.setCodigo(libroDetalles.getCodigo());
            libroExistente.setTitulo(libroDetalles.getTitulo());
            libroExistente.setAutor(libroDetalles.getAutor());
            libroExistente.setCategoria(libroDetalles.getCategoria());
            libroExistente.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            libroExistente.setPrecio(libroDetalles.getPrecio());
            libroExistente.setDisponible(libroDetalles.getDisponible());

            Libro libroActualizado = libroRepository.save(libroExistente);
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Libro>> obtenerPorCategoria(@PathVariable String categoria) {
        List<Libro> libros = libroRepository.findByCategoriaIgnoreCase(categoria);
        return ResponseEntity.ok(libros);
    }
    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> obtenerDisponibles() {
        List<Libro> libros = libroRepository.findByDisponibleTrue();
        return ResponseEntity.ok(libros);
    }
}