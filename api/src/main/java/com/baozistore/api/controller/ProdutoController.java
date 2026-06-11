package com.baozistore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.baozistore.api.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.obterTodosProdutos());
        return "produtos";
    }
}