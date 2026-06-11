package com.baozistore.api.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.baozistore.api.model.Cliente;
import com.baozistore.api.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obterClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> obtertodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setClienteDesde(clienteAtualizado.getClienteDesde());
                    return clienteRepository.save(cliente);
                })
                .orElse(null);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
