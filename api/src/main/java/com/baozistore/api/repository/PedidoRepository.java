package com.baozistore.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozistore.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    
}
