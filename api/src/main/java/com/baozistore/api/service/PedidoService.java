package com.baozistore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public Pedido obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> obterTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setClienteId(pedidoAtualizado.getClienteId());
                    pedido.setProdutoId(pedidoAtualizado.getProdutoId());
                    pedido.setQuantidade(pedidoAtualizado.getQuantidade());
                    return pedidoRepository.save(pedido);
                })
                .orElse(null);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}