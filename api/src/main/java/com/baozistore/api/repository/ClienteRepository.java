package com.baozistore.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozistore.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    
}
