package com.example.multicalculo.controller;

import com.example.multicalculo.dto.PlanoSaudeRequestDTO;
import com.example.multicalculo.entity.PlanoSaude;
import com.example.multicalculo.repository.PlanoSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoSaudeRepository planoRepo;

    @PostMapping
    public PlanoSaude cadastrar(@RequestBody PlanoSaudeRequestDTO dto) {
        PlanoSaude plano = new PlanoSaude();
        plano.setNome(dto.getNome());
        plano.setValorBase(dto.getValorBase());
        return planoRepo.save(plano);
    }


    @GetMapping
    public List<PlanoSaude> listar() {
        return planoRepo.findAll();
    }
}
