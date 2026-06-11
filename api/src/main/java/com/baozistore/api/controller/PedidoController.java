package com.baozistore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.baozistore.api.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.obterTodosPedidos());
        return "pedidos";
    }
}