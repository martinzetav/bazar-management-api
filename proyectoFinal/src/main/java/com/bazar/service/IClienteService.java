package com.bazar.service;

import com.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> getClientes();

    void saveCliente(Cliente cliente);

    void deleteCliente(Long id_cliente);

    Cliente findCliente(Long id_cliente);

    Cliente editCliente(Long id_cliente, Cliente nuevoCliente);
}
