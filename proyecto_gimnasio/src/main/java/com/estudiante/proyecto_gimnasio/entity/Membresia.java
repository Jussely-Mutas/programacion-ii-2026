package com.estudiante.proyecto_gimnasio.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "membresia")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    private EstadoMembresia estado;

    public enum EstadoMembresia {
        ACTIVA, VENCIDA, PROXIMA_A_VENCER
    }

    public Membresia() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public EstadoMembresia getEstado() { return estado; }
    public void setEstado(EstadoMembresia estado) { this.estado = estado; }
}