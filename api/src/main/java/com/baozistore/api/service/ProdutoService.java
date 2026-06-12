package com.baozistore.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.baozistore.api.model.Produto;
import com.baozistore.api.exception.ResourceNotFoundException;
import com.baozistore.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto obterProdutoPorId(UUID id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto not found with id: " + id));
    }

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(UUID id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setEstoque(produtoAtualizado.getEstoque());
                    return produtoRepository.save(produto);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Produto not found with id: " + id));
    }

    public void deletarProduto(UUID id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto not found with id: " + id);
        }
        produtoRepository.deleteById(id);
    }
}