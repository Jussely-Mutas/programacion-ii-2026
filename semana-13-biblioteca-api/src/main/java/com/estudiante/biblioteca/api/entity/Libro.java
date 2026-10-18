package com.estudiante.biblioteca.api.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;
    @Column(name = "titulo", nullable = false, length = 120)
    private String titulo;
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;
    @Column(name = "anio_publicacion", nullable = false)
    private Integer anioPublicacion;
    @Column(name = "precio", nullable = false, precision = 8, scale = 2)
    private BigDecimal precio;
    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;


    public Libro() {
    }
    public Libro(Long id, String codigo, String titulo, String autor, String categoria, Integer anioPublicacion, BigDecimal precio, Boolean disponible) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.disponible = disponible;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}