package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.model.Cliente;
import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void createCliente(Cliente cliente);

    public void deleteCliente(Long id_cliente);

    public Cliente editCliente(Long id_cliente, Cliente cliente);

    public Cliente findById(Long id_cliente);
}
