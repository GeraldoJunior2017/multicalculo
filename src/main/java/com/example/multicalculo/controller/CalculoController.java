package com.example.multicalculo.controller;

import com.example.multicalculo.dto.CalculoRequestDTO;
import com.example.multicalculo.dto.CalculoResponseDTO;
import com.example.multicalculo.service.CalculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculo")
@RequiredArgsConstructor
public class CalculoController {

    private final CalculoService calculoService;

    @PostMapping
    public CalculoResponseDTO calcular(@RequestBody @Valid CalculoRequestDTO dto) {
        return calculoService.calcularPlano(dto);
    }
}
