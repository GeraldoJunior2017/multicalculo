package com.example.multicalculo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculoRequestDTO {

    @NotBlank
    @Schema(example = "Maria da Silva", description = "Nome do cliente")
    private String nomeCliente;

    @Min(0)
    @Schema(example = "35", description = "Idade do cliente")
    private int idade;

    @Min(0)
    @Schema(example = "2", description = "Quantidade de dependentes")
    private int dependentes;

    @NotNull
    @Schema(example = "1", description = "ID do plano de saúde")
    private Long planoId;
}
