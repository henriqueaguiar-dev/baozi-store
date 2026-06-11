package com.baozistore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baozistore.api.model.Produto;
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

    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setEstoque(produtoAtualizado.getEstoque());
                    return produtoRepository.save(produto);
                })
                .orElse(null);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}