package com.bazar.controller;

import com.bazar.model.Cliente;
import com.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clientServ;

    @PostMapping("/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clientServ.saveCliente(cliente);
        return "Se creo el cliente correctamente";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Cliente> getClientes(){
        return clientServ.getClientes();
    }

    @GetMapping("/{id_cliente}")
    @ResponseBody
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clientServ.findCliente(id_cliente);
    }

    @DeleteMapping("/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clientServ.deleteCliente(id_cliente);
        return "Se elimino el cliente correctamente";
    }

    @PutMapping("/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente, @RequestBody Cliente nuevoCliente){
        if(clientServ.editCliente(id_cliente, nuevoCliente) != null) return "Se edito el cliente correctamente";
        else return "No se encontro ningun cliente con el id indicado";
    }


}
