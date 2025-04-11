package com.example.multicalculo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlanoSaudeRequestDTO {

    @NotBlank
    @Schema(example = "Plano Ouro", description = "Nome do plano de saúde")
    private String nome;

    @Positive
    @Schema(example = "299.99", description = "Valor base do plano")
    private BigDecimal valorBase;
}
