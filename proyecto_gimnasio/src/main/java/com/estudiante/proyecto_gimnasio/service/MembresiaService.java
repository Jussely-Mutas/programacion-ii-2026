package com.estudiante.proyecto_gimnasio.service;
import com.estudiante.proyecto_gimnasio.dto.MembresiaRequestDTO;
import com.estudiante.proyecto_gimnasio.entity.Cliente;
import com.estudiante.proyecto_gimnasio.entity.Membresia;
import com.estudiante.proyecto_gimnasio.entity.Plan;
import com.estudiante.proyecto_gimnasio.exception.RecursoNoEncontradoException;
import com.estudiante.proyecto_gimnasio.repository.ClienteRepository;
import com.estudiante.proyecto_gimnasio.repository.MembresiaRepository;
import com.estudiante.proyecto_gimnasio.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembresiaService {

    private final MembresiaRepository membresiaRepository;
    private final ClienteRepository clienteRepository;
    private final PlanRepository planRepository;

    public MembresiaService(MembresiaRepository membresiaRepository,
                            ClienteRepository clienteRepository,
                            PlanRepository planRepository) {
        this.membresiaRepository = membresiaRepository;
        this.clienteRepository = clienteRepository;
        this.planRepository = planRepository;
    }

    public List<Membresia> listarTodas() {
        return membresiaRepository.findAll();
    }

    public Membresia obtenerPorId(Long id) {
        return membresiaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Membresía no encontrada con ID: " + id));
    }

    public Membresia registrarMembresia(MembresiaRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + dto.getClienteId()));

        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Plan no encontrado con ID: " + dto.getPlanId()));

        LocalDate fechaInicio = dto.getFechaInicio() != null ? dto.getFechaInicio() : LocalDate.now();
        LocalDate fechaVencimiento = fechaInicio.plusDays(plan.getDuracionDias());

        Membresia membresia = new Membresia();
        membresia.setCliente(cliente);
        membresia.setPlan(plan);
        membresia.setFechaInicio(fechaInicio);
        membresia.setFechaVencimiento(fechaVencimiento);


        LocalDate hoy = LocalDate.now();
        if (fechaVencimiento.isBefore(hoy)) {
            membresia.setEstado(Membresia.EstadoMembresia.VENCIDA);
        } else if (fechaVencimiento.isBefore(hoy.plusDays(5))) {
            membresia.setEstado(Membresia.EstadoMembresia.PROXIMA_A_VENCER);
        } else {
            membresia.setEstado(Membresia.EstadoMembresia.ACTIVA);
        }

        return membresiaRepository.save(membresia);
    }

    public List<Membresia> obtenerActivas() {
        return listarTodas().stream()
                .filter(m -> m.getEstado() == Membresia.EstadoMembresia.ACTIVA)
                .collect(Collectors.toList());
    }

    public List<Membresia> obtenerVencidas() {
        return listarTodas().stream()
                .filter(m -> m.getEstado() == Membresia.EstadoMembresia.VENCIDA)
                .collect(Collectors.toList());
    }

    public List<Membresia> obtenerProximasAVencer(int dias) {
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(dias);
        return listarTodas().stream()
                .filter(m -> m.getFechaVencimiento() != null &&
                        !m.getFechaVencimiento().isBefore(hoy) &&
                        !m.getFechaVencimiento().isAfter(limite))
                .collect(Collectors.toList());
    }

    public BigDecimal obtenerIngresosPorPlan(Long planId) {
        List<Membresia> membresias = listarTodas();
        double total = membresias.stream()
                .filter(m -> m.getPlan() != null && m.getPlan().getId().equals(planId))
                .mapToDouble(m -> m.getPlan() != null && m.getPlan().getPrecio() != null ? m.getPlan().getPrecio().doubleValue() : 0.0)
                .sum();
        return BigDecimal.valueOf(total);
    }

    public void eliminarMembresia(Long id) {
        Membresia membresia = obtenerPorId(id);
        membresiaRepository.delete(membresia);
    }
}