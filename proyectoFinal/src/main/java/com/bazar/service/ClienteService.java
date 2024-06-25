package com.bazar.service;

import com.bazar.model.Cliente;
import com.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return clienteRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public Cliente editCliente(Long id_cliente, Cliente nuevoCliente) {
        Cliente cliente = this.findCliente(id_cliente);
        if(cliente != null) {
            cliente.setNombre(nuevoCliente.getNombre());
            cliente.setApellido(nuevoCliente.getApellido());
            cliente.setDni(nuevoCliente.getDni());
            this.saveCliente(cliente);
            return cliente;
        } else return null;
    }
}
