package com.example.multicalculo.service;

import com.example.multicalculo.dto.CalculoRequestDTO;
import com.example.multicalculo.dto.CalculoResponseDTO;
import com.example.multicalculo.entity.CalculoHistorico;
import com.example.multicalculo.entity.Cliente;
import com.example.multicalculo.entity.PlanoSaude;
import com.example.multicalculo.repository.CalculoHistoricoRepository;
import com.example.multicalculo.repository.ClienteRepository;
import com.example.multicalculo.repository.PlanoSaudeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculoServiceTest {

    @InjectMocks
    private CalculoService service;

    @Mock
    private PlanoSaudeRepository planoRepo;

    @Mock
    private ClienteRepository clienteRepo;

    @Mock
    private CalculoHistoricoRepository historicoRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCalcularPlanoComSucesso() {
        // Arrange
        CalculoRequestDTO dto = new CalculoRequestDTO();
        dto.setPlanoId(1L);
        dto.setNomeCliente("João");
        dto.setIdade(30);
        dto.setDependentes(2);

        PlanoSaude plano = new PlanoSaude();
        plano.setId(1L);
        plano.setNome("Plano A");
        plano.setValorBase(BigDecimal.valueOf(100.0));

        Cliente clienteSalvo = new Cliente();
        clienteSalvo.setId(1L);
        clienteSalvo.setNome(dto.getNomeCliente());
        clienteSalvo.setIdade(dto.getIdade());
        clienteSalvo.setDependentes(dto.getDependentes());

        CalculoHistorico historicoSalvo = new CalculoHistorico();
        historicoSalvo.setId(1L);
        historicoSalvo.setCliente(clienteSalvo);
        historicoSalvo.setPlano(plano);
        historicoSalvo.setValorFinal(plano.getValorBase());

        when(planoRepo.findById(1L)).thenReturn(Optional.of(plano));
        when(clienteRepo.save(any(Cliente.class))).thenReturn(clienteSalvo);
        when(historicoRepo.save(any(CalculoHistorico.class))).thenReturn(historicoSalvo);

        // Act
        CalculoResponseDTO response = service.calcularPlano(dto);

        // Assert
        assertNotNull(response);
        assertEquals(BigDecimal.valueOf(100.0), response.getValorFinal());
        verify(planoRepo, times(1)).findById(1L);
        verify(clienteRepo, times(1)).save(any(Cliente.class));
        verify(historicoRepo, times(1)).save(any(CalculoHistorico.class));
    }
}
