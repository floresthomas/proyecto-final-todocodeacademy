package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.model.Cliente;
import com.thomas.proyectofinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void createCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public Cliente editCliente(Long id_cliente, Cliente cliente) {
        Cliente cli = this.findById(id_cliente);

        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDni(cliente.getDni());

        return clienteRepo.save(cli);
    }

    @Override
    public Cliente findById(Long id_cliente) {
        return clienteRepo.findById(id_cliente).orElse(null);
    }

}
