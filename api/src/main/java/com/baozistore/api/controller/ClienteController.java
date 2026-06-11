package com.baozistore.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.baozistore.api.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.obtertodosClientes());
        return "clientes"; // Retorna o nome da view (HTML) para listar clientes
    }
    
    
}
