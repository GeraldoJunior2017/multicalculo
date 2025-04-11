package com.example.multicalculo.controller;

import com.example.multicalculo.entity.CalculoHistorico;
import com.example.multicalculo.repository.CalculoHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
@RequiredArgsConstructor
public class HistoricoController {

    private final CalculoHistoricoRepository historicoRepo;

    @GetMapping
    public List<CalculoHistorico> listarHistorico() {
        return historicoRepo.findAll();
    }
}
