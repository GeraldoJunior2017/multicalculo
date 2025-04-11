package com.example.multicalculo.dto;

import com.example.multicalculo.entity.CalculoHistorico;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CalculoResponseDTO {

    private Long id;
    private Long idPlano;
    private Long idCliente;
    private BigDecimal valorFinal;
    private LocalDateTime dataHora;

    // Construtor com CalculoHistorico
    public CalculoResponseDTO(CalculoHistorico historico) {
        this.id = historico.getId();
        this.idPlano = historico.getPlano().getId();
        this.idCliente = historico.getCliente().getId();
        this.valorFinal = historico.getValorFinal();
        this.dataHora = historico.getDataHora();
    }
}
