package com.baozistore.api.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome deve conter apenas letras e espaços")
    private String nome;
    
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d+$", message = "O celular deve conter apenas números")
    @Column(unique = true, nullable = false)
    private String celular;
    
    @NotNull
    private LocalDate clienteDesde;
}
