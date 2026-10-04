package com.estudiante.despensa.controller;
import com.estudiante.despensa.model.Producto;
import com.estudiante.despensa.model.ResumenInventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1L, "Leche Entera", "Lácteos", 5, 12.50));
        productos.add(new Producto(2L, "Queso Crema", "Lácteos", 2, 28.00));
        productos.add(new Producto(3L, "Arroz", "Granos", 4, 8.50));
        productos.add(new Producto(4L, "Frijol Blanco", "Granos", 1, 10.00));
        productos.add(new Producto(5L, "Detergente Líquido para manos", "Limpieza", 3, 45.00));
        productos.add(new Producto(6L, "Jabón de Baño", "Higiene", 10, 6.00));
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    @GetMapping("/stock-bajo")
    public List<Producto> obtenerStockBajo() {
        List<Producto> stockBajo = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCantidad() <= 3) {
                stockBajo.add(p);
            }
        }
        return stockBajo;
    }

    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Producto mayor = productos.get(0);
        for (Producto p : productos) {
            if (p.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = p;
            }
        }
        return ResponseEntity.ok(mayor);
    }

    @GetMapping("/resumen")
    public ResumenInventario obtenerResumen() {
        int cantidadProductos = productos.size();
        int totalUnidades = 0;
        double valorTotal = 0.0;

        for (Producto p : productos) {
            totalUnidades += p.getCantidad();
            valorTotal += p.calcularSubtotal();
        }

        return new ResumenInventario(cantidadProductos, totalUnidades, valorTotal);
    }
}