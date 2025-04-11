package com.example.multicalculo.service;

import com.example.multicalculo.dto.CalculoRequestDTO;
import com.example.multicalculo.dto.CalculoResponseDTO;
import com.example.multicalculo.entity.CalculoHistorico;
import com.example.multicalculo.entity.Cliente;
import com.example.multicalculo.entity.PlanoSaude;
import com.example.multicalculo.repository.CalculoHistoricoRepository;
import com.example.multicalculo.repository.ClienteRepository;
import com.example.multicalculo.repository.PlanoSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CalculoService {

    private final PlanoSaudeRepository planoRepo;
    private final ClienteRepository clienteRepo;
    private final CalculoHistoricoRepository historicoRepo;

    public CalculoResponseDTO calcularPlano(CalculoRequestDTO dto) {
        PlanoSaude plano = planoRepo.findById(dto.getPlanoId())
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNomeCliente());
        cliente.setIdade(dto.getIdade());
        cliente.setDependentes(dto.getDependentes());
        cliente = clienteRepo.save(cliente);

        BigDecimal valorFinal = plano.getValorBase(); // lógica futura: aplicar regras com base em idade/dependentes

        CalculoHistorico historico = new CalculoHistorico();
        historico.setCliente(cliente);
        historico.setPlano(plano);
        historico.setValorFinal(valorFinal);
        historico.setDataHora(LocalDateTime.now());

        CalculoHistorico salvo = historicoRepo.save(historico);

        return new CalculoResponseDTO(salvo);
    }
}
