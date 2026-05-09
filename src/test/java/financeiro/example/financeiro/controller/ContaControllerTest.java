package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.repository.ContaRepository;
import financeiro.example.financeiro.service.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ContaControllerTest {

    @Mock
    private ContaRepository repository;

    @InjectMocks
    private ContaService service;



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