package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.RequestContaDto;
import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.ContaCorrente;
import financeiro.example.financeiro.repository.ContaRepository;
import financeiro.example.financeiro.service.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ContaControllerTest {

    @Mock
    private ContaRepository repository;

    @InjectMocks
    private ContaService service;

    @Test
    void deveCriarConta() {

        RequestContaDto data = new RequestContaDto();
        data.setTipoConta("CORRENTE");
        data.setNumero("123");
        data.setBanco("Itau");
        data.setAgencia("0001");

        Conta contaSalva = new ContaCorrente();
        contaSalva.setNumero("123");
        contaSalva.setBanco("Itau");
        contaSalva.setAgencia("0001");

        when(repository.save(any(Conta.class))).thenReturn(contaSalva);

        Conta result = service.create(data);

        verify(repository).save(any(Conta.class));

        assertEquals("123", result.getNumero());
        assertEquals("Itau", result.getBanco());
        assertEquals("0001", result.getAgencia());
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}