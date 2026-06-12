package com.baozistore.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.baozistore.api.exception.ResourceNotFoundException;
import com.baozistore.api.model.Pedido;
import com.baozistore.api.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obterPedidoPorId(UUID id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found with id: " + id));
    }

    public List<Pedido> obterTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizarPedido(UUID id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setClienteId(pedidoAtualizado.getClienteId());
                    pedido.setProdutoId(pedidoAtualizado.getProdutoId());
                    pedido.setQuantidade(pedidoAtualizado.getQuantidade());
                    return pedidoRepository.save(pedido);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found with id: " + id));
    }

    public void deletarPedido(UUID id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido not found with id: " + id);
        }
        pedidoRepository.deleteById(id);
    }
}