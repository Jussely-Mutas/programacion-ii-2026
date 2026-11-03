package com.estudiante.proyecto_gimnasio.service;
import com.estudiante.proyecto_gimnasio.dto.PlanRequestDTO;
import com.estudiante.proyecto_gimnasio.entity.Plan;
import com.estudiante.proyecto_gimnasio.repository.PlanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan crearPlan(PlanRequestDTO dto) {
        Plan plan = new Plan();
        plan.setNombre(dto.getNombre());
        plan.setDescripcion(dto.getDescripcion());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracionDias(dto.getDuracionDias());
        return planRepository.save(plan);
    }

    public List<Plan> obtenerTodos() {
        return planRepository.findAll();
    }

    public Plan obtenerPorId(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado con ID: " + id));
    }

    public Plan actualizarPlan(Long id, PlanRequestDTO dto) {
        Plan plan = obtenerPorId(id);
        plan.setNombre(dto.getNombre());
        plan.setDescripcion(dto.getDescripcion());
        plan.setPrecio(dto.getPrecio());
        plan.setDuracionDias(dto.getDuracionDias());
        return planRepository.save(plan);
    }

    public void eliminarPlan(Long id) {
        Plan plan = obtenerPorId(id);
        planRepository.delete(plan);
    }
}