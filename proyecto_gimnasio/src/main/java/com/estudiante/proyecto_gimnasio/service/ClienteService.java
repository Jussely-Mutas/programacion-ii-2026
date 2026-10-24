package com.estudiante.proyecto_gimnasio.service;
import com.estudiante.proyecto_gimnasio.entity.Cliente;
import com.estudiante.proyecto_gimnasio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Map<String, Object> obtenerResumenClientes() {
        long totalClientes = clienteRepository.count();

        Map<String, Object> resumen = new HashMap<>();
        resumen.put("totalClientes", totalClientes);
        resumen.put("estadoSistema", "Activo y Operativo");
        return resumen;
    }
}