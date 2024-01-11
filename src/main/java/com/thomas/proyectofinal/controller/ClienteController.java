package com.thomas.proyectofinal.controller;

import com.thomas.proyectofinal.model.Cliente;
import com.thomas.proyectofinal.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService cliService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return cliService.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String createClientes(@RequestBody Cliente cliente) {
        cliService.createCliente(cliente);
        return "Cliente creado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteClientes(@PathVariable Long id_cliente) {
        cliService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente getClienteById(@PathVariable Long id_cliente) {
        return cliService.findById(id_cliente);
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente, Cliente cliente) {
        return cliService.editCliente(id_cliente, cliente);
    }
}
