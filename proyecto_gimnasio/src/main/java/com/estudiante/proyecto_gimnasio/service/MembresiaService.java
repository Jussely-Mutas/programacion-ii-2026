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

@Service
public class MembresiaService {

    private final MembresiaRepository membresiaRepository;
    private final ClienteRepository clienteRepository;
    private final PlanRepository planRepository;

    public MembresiaService(MembresiaRepository membresiaRepository, ClienteRepository clienteRepository, PlanRepository planRepository) {
        this.membresiaRepository = membresiaRepository;
        this.clienteRepository = clienteRepository;
        this.planRepository = planRepository;
    }

    public Membresia registrarMembresia(MembresiaRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + dto.getClienteId()));
        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Plan no encontrado con ID: " + dto.getPlanId()));

        Membresia membresia = new Membresia();
        membresia.setCliente(cliente);
        membresia.setPlan(plan);
        membresia.setFechaInicio(dto.getFechaInicio() != null ? dto.getFechaInicio() : LocalDate.now());
        membresia.setFechaVencimiento(membresia.getFechaInicio().plusDays(plan.getDuracionDias()));
        membresia.setEstado(Membresia.EstadoMembresia.ACTIVA);

        return membresiaRepository.save(membresia);
    }

    public List<Membresia> listarTodas() {
        return membresiaRepository.findAll();
    }

    public List<Membresia> obtenerActivas() {
        return membresiaRepository.findByFechaVencimientoGreaterThanEqual(LocalDate.now());
    }

    public List<Membresia> obtenerVencidas() {
        return membresiaRepository.findByFechaVencimientoBefore(LocalDate.now());
    }

    public List<Membresia> obtenerProximasAVencer(int dias) {
        LocalDate hoy = LocalDate.now();
        return membresiaRepository.findByFechaVencimientoBetween(hoy, hoy.plusDays(dias));
    }

    public BigDecimal obtenerIngresosPorPlan(Long planId) {
        BigDecimal ingresos = membresiaRepository.calcularIngresosPorPlan(planId);
        return ingresos != null ? ingresos : BigDecimal.ZERO;
    }

    public Membresia obtenerPorId(Long id) {
        return membresiaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Membresía no encontrada con ID: " + id));
    }
}