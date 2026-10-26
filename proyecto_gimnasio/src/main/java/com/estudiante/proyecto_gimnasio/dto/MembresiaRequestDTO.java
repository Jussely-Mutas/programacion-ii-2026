package com.estudiante.proyecto_gimnasio.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class MembresiaRequestDTO {

    @NotNull(message = "El ID del cliente es obligatorio")
    @Positive(message = "El ID del cliente debe ser un número positivo")
    private Long clienteId;

    @NotNull(message = "El ID del plan es obligatorio")
    @Positive(message = "El ID del plan debe ser un número positivo")
    private Long planId;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    public MembresiaRequestDTO() {}

    // Getters y Setters corregidos con la "e" (getClienteId)
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}